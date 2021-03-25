
public class Demo{

public int add(int a,int b){

try{

return a+b;

}catch(Exception e){

System.out.println("Catch Óï¾ä¿é");

}finally{

System.out.println("finally Óï¾ä¿é");
}

return 0;
}



public static void main(String[] args){

Demo demo = new Demo();

System.out.println("ºÍÊÇ£º"+demo.add(9,34));

}
}