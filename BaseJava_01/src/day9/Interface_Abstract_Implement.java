package day9;

/**
 * 
 * 如果实现类是抽象方法,则不用实现接口的所有抽象方法
 * 但是抽象类是不能创建对象的
 *
 */
public abstract class Interface_Abstract_Implement implements Teacher{

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 只实现了备课,没有实现上课
	 */
}
