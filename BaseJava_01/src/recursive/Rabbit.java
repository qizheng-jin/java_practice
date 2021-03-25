package recursive;

public class Rabbit {
	//����µ����������� = ���������� + С������
	// С������ = �ϸ���С������ + ������ܳ��������� - ������иճ����С������;
	// ����������� =�ϸ��³���������� + ������иճ����С������
	//����µ����������� = �ϸ������������� + ����³���������� 
	//����³���������� = 3����ǰ������������
	
	public static int rabbit(int month) {
		if(month <= 2) return 2;
		return rabbit(month-1) + rabbit(month-3);
	}
	
	public static void main(String[] args) {
		for(int i=0; i<=12; i++) {
			System.out.println("��"+i +"���µ������ܶ���: " + rabbit(i)/2);
		}
	}
}
