
public class Linked_List {
	Node head = null; // ͷ�ڵ�
	String line = "";
	/**
	 * ������β����������,��������������������ֵ
	 */
	public void addNode(int d) {
		Node newNode = new Node(d);
		//�����ͷ�ڵ���ֱ�Ӳ���
		if(head == null) {
			head = newNode;
			return ;
		}
		/**
		 * �������ͷ�ڵ�,����ѭ��,
		 * ��ѭ��ָ��ѭ���������β,Ȼ������µ�Ԫ��
		 */
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	
	/**
	 * ������ͷ������ڵ�
	 */
	public void addHead(int d) {
		Node newNode = new Node(d);
		if(head == null) {
			head = newNode;
			return ;
		}
		Node tmp = head;
		newNode.next = tmp;
		head = newNode;
	}
	
	/**
	 * �����������
	 */
	public void printAll() {
		if(head == null) System.out.println("����һ��������");
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + ";");
			temp = temp.next;
		}
	}
	
	/**
	 * ����������
	 */
	public int length() {
		int len = 0;
		Node temp = head;
		while(temp != null) {
			len ++;
			temp = temp.next;
		}
		return len;
	}
	
	/**
	 * 
	 * ɾ��ָ��λ�õĽڵ�
	 */
	public boolean deleteIndex(int index) {
		if(index < 1 || index > length()) return false;
		//ɾ��ͷ�ڵ�
		if(index == 1) {
			head = head.next;
			return true;
		}
		int iterator = 1;
		Node temp = head;
		//�ߵ���ɾ���ڵ��ǰһλ,��ǰһλ��.next �뱻ɾ���ڵ��.next������.
		while(iterator < index-1) {
			temp = temp.next;
			iterator ++;
		}
		Node deleteNode = temp.next;
		temp.next = deleteNode.next;
		System.out.println("�Ѿ�ɾ��" + deleteNode.data);
		return true;
	}
	
	/**
	 * ɾ����һ�����ֵĽڵ�
	 */
	public boolean deleteNode(int value) {
		if(head.data == value) {
			head = head.next;
			return true;
		}
		Node temp = head;
		while(temp != null) {
			if(temp.next != null) {
				if(temp.next.data == value) {
					if(temp.next.next != null) {
						temp.next = temp.next.next;
					}else {
						temp.next = null;
					}
					return true;
				
				}
			}
			temp = temp.next;
		}
		return false;
	
	
	}
	public static void main(String[] args) {
		Linked_List myList = new Linked_List();
		myList.addHead(3);
		myList.addNode(12);
		myList.addNode(15);
		myList.addNode(13);
		myList.addNode(25);
		myList.addNode(65);
		myList.printAll();
		System.out.println();
		System.out.println("The length of linked list is "+myList.length());
		//myList.deleteIndex(3);
		myList.deleteNode(65);
		myList.printAll();
	}
}
