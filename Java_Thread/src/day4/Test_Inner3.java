package day4;

/**���������ڲ���*/
public class Test_Inner3 {
	public static void main(String[] args) {
		//�������� �൱�ڴ�����һ���ӿڵ�ʵ���࣬������д�˽ӿ��е����г��󷽷�
		new Inner1() {

			@Override
			public void get() {
				// TODO Auto-generated method stub
				System.out.println("get����");
			}

			@Override
			public void save() {
				// TODO Auto-generated method stub
				System.out.println("save����");
			}
		}.get();//����ָ������д��ķ���, ��������ֻ�ܵ���һ������,��ֻ�ܵ���һ��
		
	}
}

//�����ӿ� Inner
interface Inner1{
	void get();
	void save();
}