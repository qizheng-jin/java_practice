package day4;

/**�����ڲ���*/
public class Test_InnerClass {
	public static void main(String[] args) {
		/**�����ڲ������,ʹ���ڲ�����Դ
		 * �ⲿ����.�ڲ����� ������ = �ⲿ�����.�ڲ������
		 * */
		Outer.Inner inner = new Outer().new Inner();
		//���÷�����һ�����һ��
		inner.get();
		
		//��������: new ����(); ֻ����һ��,��ʱ��
		new Outer().find();
		
		/**
		 * �����Ա�ڲ��౻private���Σ�����ε��ã�
		 * ���ⲿ���д���˽���ڲ������
		 */
		Outer out = new Outer();
		out.getInner().get();
	}

}

class Outer{
	//�����ⲿ������
	String name;
	int age;
	Inner inner;
	//�����ⲿ���Ա����
	public void find() {
		System.out.println("Outer...find()...");
		/**
		 * �ⲿ��Ҫʹ���ڲ�����Դ
		 * �����ȴ����ڲ���Ķ���ͨ���ڲ��������з���
		 */
		Inner in = new Inner();
		in.get();
	}

	/**
	 * �ڲ��� -- �������Ϊ�ⲿ��������Ա
	 * 1. ��Ա�ڲ���: ���﷽����
	 * 2. �ֲ��ڲ���: ������
	 * */
	 class Inner{
		private int count = 10;
		//�����ڲ��෽��
		public void get() {
			System.out.println("inner...get()...");
		}
	}
	 
	 
	 public Inner getInner() {
		 if(inner == null) {
			 inner = new Inner();
		 }
		 return inner;
	 }
}