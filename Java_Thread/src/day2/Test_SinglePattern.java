package day2;
/**
 * 
 * �������ڲ��Ե������ģʽ -- ����ʽ
 * ��������,����ֻ��һ��
 * ���е���ģʽ����Ҫ����ȷ������ֻ��һ����
 * �Ա��๹�췽��˽�л�,��ֹ�ⲿ���ù��췽����������
 * ����ȫ��Ψһ�Ķ���,Ҳ��˽�л�����
 * ͨ���Զ���Ĺ��������������õĶ��󷵻�(���Ʒ�װ���Ժ��getXxx() )
 */
public class Test_SinglePattern {
	public static void main(String[] args) {
		MySingle single = MySingle.getSingle();
		MySingle single2 = MySingle.getSingle();
		System.out.println(single == single2);
	}
}

//1. �����Լ��ĵ�������
class MySingle{
	//1. �ṩ���췽��,�������췽��˽�л�
	private static MySingle single = new MySingle();
	private String line;
	/**���췽��˽�л���Ŀ����Ϊ�˲����������ʵ��������*/
	private MySingle() {}
	
	private MySingle(String line) {
		this.line = line;
	}
	public static MySingle getSingle() {
		return single;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}
}
