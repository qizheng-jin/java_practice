
public class Linked_List {
	Node head = null; // 头节点
	String line = "";
	/**
	 * 向链表尾部插入数据,参数是这个链表中所存的值
	 */
	public void addNode(int d) {
		Node newNode = new Node(d);
		//如果是头节点则直接插入
		if(head == null) {
			head = newNode;
			return ;
		}
		/**
		 * 如果不是头节点,则创立循环,
		 * 用循环指针循环到链表结尾,然后插入新的元素
		 */
		Node tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	
	/**
	 * 在链表头部插入节点
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
	 * 遍历输出链表
	 */
	public void printAll() {
		if(head == null) System.out.println("这是一个空链表");
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data + ";");
			temp = temp.next;
		}
	}
	
	/**
	 * 返回链表长度
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
	 * 删除指定位置的节点
	 */
	public boolean deleteIndex(int index) {
		if(index < 1 || index > length()) return false;
		//删除头节点
		if(index == 1) {
			head = head.next;
			return true;
		}
		int iterator = 1;
		Node temp = head;
		//走到被删除节点的前一位,将前一位的.next 与被删除节点的.next向连接.
		while(iterator < index-1) {
			temp = temp.next;
			iterator ++;
		}
		Node deleteNode = temp.next;
		temp.next = deleteNode.next;
		System.out.println("已经删除" + deleteNode.data);
		return true;
	}
	
	/**
	 * 删除第一个出现的节点
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
