package day9;

/**
 * ���ӿ����ڴ����ӿڲ���
 * 1. ����ͨ��interface�ؼ���������ӿ�
 * 2  �ӿ��в�������ͨ����
 * 3. �ӿ���ֻ���г��󷽷�
 *
 */
public interface Interface_Test {
	int i =10;
	public abstract void skillq();
	public abstract void skillw();
}

interface UserInterface{
	/**
	 * �ӿ��ж���ı���Ĭ��Ϊ����, Ĭ�ϼ��� static final,���Կ���ֱ������������
	 */
	double pi = 3.14; //���븳ֵ
	public abstract void abstractMethod();
	
}

/**
 * ʵ�ʰ���
 * */

interface Teacher{
	void prepare();
	void teach();
}



