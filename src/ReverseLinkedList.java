public class ReverseLinkedList {

	private static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	private static String toString(Node start) {
		StringBuilder sb = new StringBuilder();
		Node current = start;
		while (current != null) {
			sb.append(current.data + "->");
			current = current.next;
		}
		return sb.toString();
	}

	private static Node reverse(Node current, Node prev) {
		if (current == null)
			return null;

		Node start = reverse(current.next, current);
		if (start == null) {
			start = current;
		}
		current.next = prev;
		return start;
	}
	
	
	private static Node reverseWhile(Node start) {
	
		Node current = start; Node prev = null, next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			
		}

		return prev;
	
	}
	

	public static void main(String[] args) {

		Node five = new Node(5, null);
		Node four = new Node(4, five);
		Node three = new Node(3, four);
		Node two = new Node(2, three);
		Node one = new Node(1, two);

		System.out.println(toString(one));
		System.out.println(toString(reverse(one, null)));
		System.out.println(toString(reverseWhile(five)));

	}

}
