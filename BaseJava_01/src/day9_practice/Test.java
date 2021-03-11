package day9_practice;

/**
 * 
 * 接口可以继承别的接口,继承完之后拥有被继承接口的所有方法
 * 由于java是单继承多实现的,所以我们一般先继承再实现
 *
 */
interface Total_Inter extends Save_Inter, Search_Inter{
	
}

public class Test implements Save_Inter, Search_Inter{

	@Override
	public void update() {
		System.out.println("更新完毕");
	}

	@Override
	public void search() {
		System.out.println("查询中,请稍后");
	}

	@Override
	public void save() {
		System.out.println("保存成功");
	}

	@Override
	public void delete() {
		System.out.println("稍等...正在删除中...");
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.update();
		test.search();
		test.delete();
		test.save();
	}
}
