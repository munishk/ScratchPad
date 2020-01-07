public class DoublyLinkedList {
	Node first, last;

	private static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data, Node next, Node prev) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

	void insertFirst(int element) {
		Node newElement = new Node(element, null, null);
		if (first == null) {
			first = newElement;
			last = newElement;
		} else {
			newElement.next = first;
			first.prev = newElement;
			first = newElement;
		}
	}

	void insertLast(int element) {
		Node newElement = new Node(element, null, null);
		if (first == null) {
			first = newElement;
			last = newElement;
		} else {
			last.next = newElement;
			newElement.prev = last;
			last = newElement;
		}
	}

	Node delete(int element) {
		Node current = find(element);
		if (current != null) {
			if (current == first) {
				current.next.prev = null;
				first = current.next;
			} else if (current == last) {
				current.prev.next = null;
				last = last.prev;
			} else {
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
		}
		return current;
	}

	Node find(int element) {
		Node left = first;
		Node right = last;

		while (left != null && left.data != element && right != null
				&& right.data != element) { // TODO find a way to stop when it
											// reaches half.
			left = left.next;
			right = right.prev;
		}

		if (left != null && left.data == element) {
			return left;
		}
		if (right != null && right.data == element) {
			return right;
		}
		return null;
	}

	void print() {
		StringBuilder strBuilder = new StringBuilder();
		boolean firstElement = true;
		Node current = first;
		while (current != null) {
			if (firstElement) {
				strBuilder.append(current.data);
				firstElement = false;
			} else {
				strBuilder.append("->" + current.data);
			}
			current = current.next;
		}
		System.out.println(strBuilder);
	}

	void printLast() {
		StringBuilder strBuilder = new StringBuilder();
		boolean firstElement = true;
		Node current = last;
		while (current != null) {
			if (firstElement) {
				strBuilder.append(current.data);
				firstElement = false;
			} else {
				strBuilder.append("->" + current.data);
			}
			current = current.prev;
		}
		System.out.println(strBuilder);
	}

	public static void main(String[] args) {
		/*
		 * DoublyLinkedList stack = new DoublyLinkedList();
		 * 
		 * stack.insertFirst(10); stack.insertFirst(20); stack.insertFirst(30);
		 * stack.insertFirst(40); stack.insertFirst(50); stack.insertFirst(60);
		 * 
		 * stack.print();
		 * 
		 * stack.delete(30); stack.print();
		 * 
		 * stack.delete(30); stack.print();
		 */

		DoublyLinkedList queue = new DoublyLinkedList();

		queue.insertLast(10);
		queue.insertLast(20);
		queue.insertLast(30);
		queue.insertLast(40);
		queue.insertLast(50);
		queue.insertLast(60);

		queue.print();
		queue.printLast();

		queue.delete(30);
		queue.print();

		queue.delete(30);
		queue.print();

	}

}
