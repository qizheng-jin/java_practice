package day9_practice;

/**
 * 
 * �ӿڿ��Լ̳б�Ľӿ�,�̳���֮��ӵ�б��̳нӿڵ����з���
 * ����java�ǵ��̳ж�ʵ�ֵ�,��������һ���ȼ̳���ʵ��
 *
 */
interface Total_Inter extends Save_Inter, Search_Inter{
	
}

public class Test implements Save_Inter, Search_Inter{

	@Override
	public void update() {
		System.out.println("�������");
	}

	@Override
	public void search() {
		System.out.println("��ѯ��,���Ժ�");
	}

	@Override
	public void save() {
		System.out.println("����ɹ�");
	}

	@Override
	public void delete() {
		System.out.println("�Ե�...����ɾ����...");
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.update();
		test.search();
		test.delete();
		test.save();
	}
}
