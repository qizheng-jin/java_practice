package day7;

/**
 * 
 * 提取共同点,向上造型                                                              
 *
 */
public class Polymorphism_Test2 {
	public static void main(String[] args) {
		//创建父类进行测试
		Car car = new Car();
		car.getColor();
		car.start();
		car.stop();
		
		//BMW子类
		BMW bmw = new BMW();
		bmw.start();
		bmw.stop();
		
		//Benz子类
		Benz benz = new Benz();
		benz.start();
		benz.stop();
	}
}

class Car{
	private String brand;
	private String color;
	
	public void start() {
		System.out.println("车启动了");
	}
	
	public void stop() {
		System.out.println("车停止了");
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}

//1.创建一个宝马类
class BMW extends Car{
	//3. 定义宝马类的属性
	String brand = "BMW";
	String color;
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("宝马启动");
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("宝马停止");
	}

}


//2. 奔驰
class Benz extends Car{
	String brand;
	String color;
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("奔驰启动");
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("奔驰停止");
	}
	
    
}