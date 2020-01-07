import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		int[] arr = { 21, 32, 10, 89, 11 };

		findNextGreaterElement(arr);

	}

	private static void findNextGreaterElement(int[] arr) {

		Stack<Integer> stack = new Stack();

		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] <= stack.peek()) {

				stack.push(arr[i]);

			} else {

				while (!stack.empty() && stack.peek() < arr[i]) { // loops till
																	// it finds
																	// a larger
																	// element

					int temp = stack.pop();

					System.out.println("NGE for " + temp + ":" + arr[i]);

				}

				stack.push(arr[i]);// then finally gets looped in

			}

		}

		// for remaining stack

		while (!stack.empty()) {

			int temp = stack.pop();

			System.out.println("NGE for " + temp + ":" + -1);

		}

	}

}