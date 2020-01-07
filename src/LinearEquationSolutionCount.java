public class LinearEquationSolutionCount {

	public static void main(String[] args) {
		int[] arr = { 1,2 };
		System.out.println(countSol(arr, 0, arr.length - 1, 5));
	}

	private static int countSol(int[] arr, int low, int high, int rhs) {
		if (rhs == 0) {
			return 1;
		}

		int result = 0;
		for (int i = low; i <= high; i++) {
			if (arr[i] <= rhs) {
				result += countSol(arr, i, high, rhs - arr[i]);
			}
		}

		return result;
	}

}
