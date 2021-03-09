package day7;

/**
 * 
 * ��ȡ��ͬ��,��������                                                              
 *
 */
public class Polymorphism_Test2 {
	public static void main(String[] args) {
		//����������в���
		Car car = new Car();
		car.getColor();
		car.start();
		car.stop();
		
		//BMW����
		BMW bmw = new BMW();
		bmw.start();
		bmw.stop();
		
		//Benz����
		Benz benz = new Benz();
		benz.start();
		benz.stop();
	}
}

class Car{
	private String brand;
	private String color;
	
	public void start() {
		System.out.println("��������");
	}
	
	public void stop() {
		System.out.println("��ֹͣ��");
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

//1.����һ��������
class BMW extends Car{
	//3. ���屦���������
	String brand = "BMW";
	String color;
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("��������");
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("����ֹͣ");
	}

}


//2. ����
class Benz extends Car{
	String brand;
	String color;
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("��������");
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
		System.out.println("����ֹͣ");
	}
	
    
}