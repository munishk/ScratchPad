import test.SingleLinkedList.Node;


public class MergeSortedLinkedList {

	public static void main(String[] args) {
		SingleLinkedList first = new SingleLinkedList();
		first.insertLast(5);
		first.insertLast(10);
		first.insertLast(20);

		first.print();
		
		SingleLinkedList second = new SingleLinkedList();
		second.insertLast(2);
		second.insertLast(12);
		second.insertLast(18);
		second.insertLast(35);

		second.print();
		
		Node merged = merge(first.first, second.first);
        print(merged);
	}
	
	  static void print(Node start) {
	    	StringBuilder strBuilder = new StringBuilder();
	    	boolean firstElement = true;
	    	Node current = start;
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
	
	private static Node merge(Node first, Node second) {
		Node current1= first;
		Node current2 = second;
		
		Node start = null, tail=null;
		
		while(current1 != null && current2 != null) {
			if(current1.data < current2.data) {
				if(start == null) {
					start = current1;
					tail = current1;
					current1 = current1.next;
				}else {
					if(tail == current1) {
						tail.next = tail.next;
						current1 = current1.next;
					}else {
						Node temp = current1;
						current1 = current1.next;
						temp.next = tail.next;
						tail.next = temp;
						tail = tail.next;
					}
				}
				
			}else {
				if(start == null) {
					start = current2;
					tail = current2;
					current2 = current2.next;
				}else {
					if(tail == current2) {
						tail = tail.next;
						current2 = current2.next;
					}else {
						Node temp = current2;
						current2 = current2.next;
						temp.next = tail.next;
						tail.next = temp;
						tail = tail.next;
					}
				}
			}
		}
		
		if(current1 != null && tail != current1) {
			if(tail == null) {
				return current1;
			}
			tail.next = current1;
		}
		
		if(current2 != null && tail != current2) {
			if(tail == null) {
				return current2;
			}
			tail.next = current2;
		}
		
		return start;
		
	}

}
