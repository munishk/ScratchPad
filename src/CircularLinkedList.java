public class CircularLinkedList {

	Node head;

	void insert(int element) {
		Node node = new Node(element, null);
		if (head == null) {
			head = node;
			head.next = head;
		} else {
			node.next = head.next;
			head.next = node;
			head = head.next;
		}
	}

	void sortedInsert(int element) {
		Node node = new Node(element, null);
		if (head == null) {
			head = node;
			head.next = head;
		} else {
			if (element >= head.data) {
				node.next = head.next;
				head.next = node;
				head = head.next;
			} else {
				Node current = head;
				while (current.next != null && current.next.data < element) {
					current = current.next;
				}
				node.next = current.next;
				current.next = node;
			}
		}

	}

	Node remove() {
		if (head == null)
			return null;

		if (head == head.next) {
			Node temp = head;
			head = null;
			return temp;
		}
		Node temp = head.next;
		head.next = head.next.next;
		return temp;
	}

	void print() {
		if (head == null) {
			System.out.println("Empty");
			return;
		}
		StringBuilder strBuilder = new StringBuilder();
		Node current = head.next;
		while (current != head) {
			strBuilder.append(current.data + "->");
			current = current.next;
		}
		strBuilder.append(current.data);
		System.out.println(strBuilder);
	}

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
		// Queue implementation
		System.out.println("----- Circular Queue ----");
		CircularLinkedList queue = new CircularLinkedList();
		queue.insert(10);
		queue.insert(20);
		queue.insert(30);
		/*
		 * queue.insert(40); queue.insert(50); queue.insert(60);
		 */

		queue.print();

		queue.remove();
		queue.print();

		queue.remove();
		queue.print();

		queue.remove();
		queue.print();
		
		      // Sorted Queue implementation
				System.out.println("----- Sorted Circular Queue ----");
				CircularLinkedList sortedQueue = new CircularLinkedList();
				sortedQueue.sortedInsert(10);
				sortedQueue.sortedInsert(5);
				sortedQueue.sortedInsert(20);
				sortedQueue.print();
				sortedQueue.sortedInsert(2);
	
				sortedQueue.print();
	}

}
