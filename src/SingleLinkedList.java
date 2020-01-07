public class SingleLinkedList {
	
	Node first, last;
	
	 static class Node {
		int data;
		Node next;
		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
		
	}

	public static void main(String[] args) {
		
	/*	//Stack implementation
		SingleLinkedList stack = new SingleLinkedList();
		stack.insertFirst(10);
		stack.insertFirst(20);
		stack.insertFirst(30);
		stack.insertFirst(40);
		stack.insertFirst(50);
		stack.insertFirst(60);
		
		stack.print();

		
	    stack.deleteFirst();
	    stack.print(); */
		
		
		//Queue implementation
		System.out.println("----- Queue ----");
				SingleLinkedList queue = new SingleLinkedList();
				queue.insertLast(10);
				queue.insertLast(20);
				queue.insertLast(30);
				queue.insertLast(40);
				queue.insertLast(50);
				queue.insertLast(60);
				
				queue.print();
				queue.rotate(2);
				
				queue.print();
				
				/*queue.print();
				queue.deleteFirst();
				queue.print();*/
		

	}
	
	
	void rotate(int k) {
		Node fast = first;
		int counter = 0;
		while(counter++ < k && fast.next != null) {
			fast = fast.next;
		}
		
		Node slow = first;
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		fast.next = first;
		first = slow.next;
		last = slow;
		slow.next = null;
		
	}
	
	void insertFirst(int element) {
       Node current = new Node(element, null);
		if(first == null) {
			first = current;
			last = current;
		}else {
		current.next = first;
		first = current;
		}
	}
	
	void insertLast(int element) {
	       Node current = new Node(element, null);
			if(first == null) {
				first = current;
				last = current;
			}else {
			last.next = current;
			last = current;
			}
		}
	
	Node deleteFirst() {
		Node deleted = first;
		first = first.next;
		return deleted;
	}
	
	 Node find(int element) {
		Node current = first;
		while(current != null) {
			if(current.data == element) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	 
	 Node delete(int element) {
		Node current = first;
		Node prev = current;
		while(current != null) {
			if(current.data == element) {
				if(prev == current) {
					first = first.next;
				}else  {
				prev.next = current.next;
				}
				return current;
			}
			prev = current;
			current = current.next;
		}
		return null;
	 }
	 
    void print() {
    	StringBuilder strBuilder = new StringBuilder();
    	boolean firstElement = true;
    	Node current = first;
    	while(current != null) {
    		if(firstElement) {
    			strBuilder.append(current.data);
    			firstElement = false;
    		}else {
    		strBuilder.append( "->" +current.data );
    		}
    		current = current.next;
    	}
    	System.out.println(strBuilder);
    }

}
