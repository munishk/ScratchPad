public class MultiplyPolynomial {
	
	static int[] multiply(int[] a, int[] b) {
		int[] result = new int[a.length  + b.length -1];
		for(int i=0; i < a.length; i++) {
			for(int j=0; j< b.length; j++) {
				result[i+j] = result[i+j] + a[i] *b[j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = {5,0,10,6};
		int[] b = {1,2,4};

		int[] result = multiply(a, b);
		
		for(int value: result) {
			System.out.print(value + " ");
		}
	}

}
