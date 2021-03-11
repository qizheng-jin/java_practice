package day9;

/**
 * 如果继承接口的类是一个抽象类的话,就不需要强制要求重写父类的所有抽象方法
 * 
 * 如果实现类想要使用接口的功能就需要与接口建立实现关系(implements)
 */

public class Interface_Implement implements Interface_Test, UserInterface, Teacher{ //extends

	@Override
	public void skillq() {
		System.out.println("这是Q技能");
	}

	@Override
	public void skillw() {
		System.out.println("这是w技能");
	}
	
	@Override
	public void abstractMethod() {
		
	}
	
	@Override
	public void prepare() {
		System.out.println("老师备课");
	}

	@Override
	public void teach() {
		System.out.println("老师上课");
	}
	
	public static void main(String[] args) {
		Interface_Implement ic = new Interface_Implement();
		ic.skillq();
		ic.skillw();
		/**
		 * 接口向上造型没有意义,使用的还是全都是子类的方法,因为接口完全抽象
		 */
		Interface_Test it = new Interface_Implement();
		it.skillq();
		it.skillw();
		
		System.out.println(Interface_Implement.pi);//常量可以直接用类呼叫
	}


	
	


}
