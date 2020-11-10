package keyword;

public class LinkedList<T> {
	
	private class Node{
		public T t;
		public Node next;
		public Node(T t, Node next) {
			this.t = t;
			this.next = next;
		}
	}
	
	@SuppressWarnings("unused")
	private int index = 0;
	private int size = 0;
	private Node current;
	private Node head;
	
	
	public boolean isEmpty() {
		// 1. check if the list is empty
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		// 2. return size of the list
		current = head;
		if (head == null) {
			size = 0;
		}
		else {
			size = 1;
			while(current.next != null) {
				current = current.next;
				size++;
			}
		}
		return size;
	}
	public void resetIndex() {
		index = 0;
		current = head;
	}
	public void add(T t) {
		if(size == 0) {
			head = new Node(t, null);
		}
		else {
			current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node(t, null);
		}
		size++;
		resetIndex();
	}
	public void add(int index, T t) {
		// 3. add new node by using given index
		current = head;
		if (index == 0) {
			head = new Node(t, current);
		}
		else {	
			for(int i = 0; i < index-1; i++) {
			current = current.next;
			}
			current.next = new Node(t, current.next);
		}
		size++;
		resetIndex();
	}
	
	public T get(int index) {
		// 4. return the node at given index
		current = head;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.t;
	}
	
	public T remove(int index) {
		// 5. remove the node at given index and return the node
		current = head;
		if (index == 0) {
			head = current.next;
		}
		else {
			for(int i = 0; i < index-1; i++) {
				current = current.next;
			}
			current.next = current.next.next;
		}
		size--;
		resetIndex();
		return null;
		
	}

	public void printList() {
		//6. print the list 
		current = head;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			sb.append(current.t.toString()); 
		    if(i>0){
		    	sb.append(" ");
		    } 
		    current = current.next;
		}
		System.out.println(sb.toString());
	}
	

}