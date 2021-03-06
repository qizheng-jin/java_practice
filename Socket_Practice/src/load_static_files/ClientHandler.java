package load_static_files;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *  负责与指定客户端进行HTTP交互
 *  HTTP协议要求与客户端的交互规则采取一问一答的方式。因此，处理客户端交互以3步形式完成:
 *  1:解析请求(一问)
 *  2:处理请求
 *  3:发送响应(一答)
 */
public class ClientHandler implements Runnable{
    private Socket socket;
    private String defaultPath = "Webapps";
    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try{
            //1解析请求
            HttpRequest request = new HttpRequest(socket);
            HttpResponse response = new HttpResponse(socket);

            //2处理请求
            //首先通过request获取请求中的抽象路径
            String path = request.getUri();
            File file = new File(defaultPath+path);
            //若该资源存在并且是一个文件，则正常响应
            /*
             * 1.创建一个map，储存（静态文件， 文件类型）
             * 2。得到file路径，并且获得文件资源后缀
             * 3. 通过静态文件,找到静态文件类型,将它作为Content-Type.
             * 4. response.setEntity(file)
             */
            if(file.exists()&&file.isFile()){
                System.out.println("该资源已找到:"+file.getName());
                Map<String,String> mimeMapping = new HashMap<>();
                mimeMapping.put("html","text/html");
                mimeMapping.put("css","text/css");
                mimeMapping.put("js","application/javascript");
                mimeMapping.put("png","image/png");
                mimeMapping.put("gif","image/gif");
                mimeMapping.put("jpg","image/jpeg");
                //ios.png
                String fileName = file.getName();
                String ext = fileName.substring(fileName.lastIndexOf(".")+1); //获得资源后缀
                System.out.println("***************ext is " + ext);
                String type = mimeMapping.get(ext);
                response.putHeader("Content-Type",type);
                response.putHeader("Content-Length",file.length()+"");
                response.setEntity(file);

            //若资源不存在则响应404
            }else{
                System.out.println("该资源不存在!");
                File notFoundPage = new File(defaultPath + "/html_files/404_not_found.html");
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                response.putHeader("Content-Type","text/html");
                response.putHeader("Content-Length",notFoundPage.length()+"");
                response.setEntity(notFoundPage);
            }

            //统一设置其他响应头
            response.putHeader("Server","WebServer");//Server头是告知浏览器服务端是谁

            //3发送响应
            response.flush();

            System.out.println("响应发送完毕!");
        }catch(EmptyRequestException e){
            //什么都不用做,上面抛出该异常就是为了忽略处理和响应操作
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //处理完毕后与客户端断开连接
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}

