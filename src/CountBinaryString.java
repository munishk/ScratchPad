public class CountBinaryString {
	
	static int count(int n, String prefix) {
		if(n ==0) {
			return 1;
		}
		
		int count = 0;
		count = count + count(n-1, prefix + "0");
		
		if(prefix.isEmpty() || prefix.charAt(prefix.length() -1) != '1') {
			count = count + count(n-1, prefix + "1");
		}
		return count;
		
	}

	public static void main(String[] args) {
		System.out.println(count(4,""));

	}

}
