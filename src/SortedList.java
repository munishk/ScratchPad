public class SortedList {

	Node first;

	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	void insert(int element) {
		Node newElement = new Node(element, null);
		if (first == null) {
			first = newElement;
		} else if (element < first.data) {
			newElement.next = first;
			first = newElement;
		} else {

			Node prev = first;
			Node current = first;
			while (current != null && current.data <= element) {
				prev = current;
				current = current.next;
			}
			newElement.next = prev.next;
			prev.next = newElement;

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

	public static void main(String[] args) {
		//Stack implementation
		SortedList sortedList = new SortedList();
		sortedList.insert(15);
		sortedList.insert(10);
		sortedList.insert(20);
		sortedList.insert(5);
		sortedList.insert(80);
		sortedList.insert(100);
		sortedList.insert(1);
		
		sortedList.print();
	}

}
