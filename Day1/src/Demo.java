
public class Demo{

public int add(int a,int b){

try{

return a+b;

}catch(Exception e){

System.out.println("Catch ����");

}finally{

System.out.println("finally ����");
}

return 0;
}



public static void main(String[] args){

Demo demo = new Demo();

System.out.println("���ǣ�"+demo.add(9,34));

}
}