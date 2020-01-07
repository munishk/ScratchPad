public class LexicographicOrder {
	
	static int getLexicOrder(String input, String original, int n) {
		if(n == 1) {
			return 1;
		}
		
		char c= input.charAt(input.length() - n);
		int index = original.indexOf(c);
		return index * fact(n-1) + getLexicOrder(input, remove(original, c), n -1);
	}
	
	static String remove(String original, char c) {
		int index = original.indexOf(c);
		return original.substring(0, index) + original.substring(index+1);
	}
	
	static int fact(int n) {
		int total = 1;
		for(int i=n; i > 1; i--) {
			total*=i;
		}
		return total;
	}

	public static void main(String[] args) {
		int order = getLexicOrder("dcba", "abcd", 4);
		System.out.println(order);

	}

}
