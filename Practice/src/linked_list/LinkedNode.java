package linked_list;

public class LinkedNode<E> {
	private Node<E> head = null;
	
	/**ÄÚ²¿Àà*/
	private class Node<E> {
		E e;
		Node<E> next;
		public Node(E e) {
			this.e = e;
			next = null;
		}
	}
	
	
	public void addFirst(E e) {
		Node<E> thisNode = new Node<E>(e);
		if(head == null) {
			head = thisNode;
			return ;
		}
		Node<E> temp = head;
		head = thisNode;
		head.next = temp;
	}
	
	public void addLast(E e) {
		Node<E> thisNode = new Node<E>(e);
		if(head == null) {
			head = thisNode;
			return;
		}
		Node<E> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = thisNode;
	}
	
	public boolean deleteValue(E e) {
		if(head == null) {
			return false;
		}
		if(head.next == null) {
			if(head.e.equals(e)) return true;
			return false;
		}
		Node<E> temp = head;
		while(temp.next != null) {
			if(temp.next.e.equals(e)) {
				if(temp.next.next != null) {
					temp.next = temp.next.next;
					return true;
				}else {
					temp.next = null;
					return true;
				}
			}
			temp = temp.next;
		}
		return false;
	}
	
	public int length() {
		
		if(head == null) {
			return 0;
		}
		int length = 1;
		Node temp = head;
		while(temp.next != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	
	public boolean deleteIndex(int a) {
		if(a<0 || a>=length()) {
			return false;
		}
		if(a == 0) {
			if(head == null) return true;
			head = head.next;
			return true;
		}
		int iterator = 0;
		Node temp = head;
		while(iterator<a) {
			temp = temp.next;
			
		}
		if(temp.next.next != null) {
			temp.next = temp.next.next;
			return true;
		}else {
			temp.next = null;
			return true;
		}
		
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node temp = head;
		for(int i=0; i<length(); i++) {
			builder.append(temp.e.toString());
			builder.append("/");
			temp = temp.next;
		}
		return builder.toString();
	}
	
	
	public static void main(String[] args) {
		LinkedNode<String> ln = new LinkedNode<String>();
		ln.addLast("AAA");
		ln.addLast("BBB");
		ln.addLast("CCC");
		ln.addFirst("000");
		System.out.println(ln.deleteValue("AAA"));
		System.out.println(ln.toString());
	}
}
