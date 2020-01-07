public class PermutationWithSwap {
	
	static void perm(char[] input, int start, int end) {
		if(start== end) {
			System.out.println(input);
		}else {
			for(int i=start; i<=end; i++) {
				if(i != start && input[i] == input[start]) {
					continue;
				}
				swap(input, start, i);
				perm(input, start+1, end);
				swap(input, start,i);  //move back character to original position
			}
		}
	}
	
	static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
    static void print(char[] input) {
    	for(char c: input) {
    	System.out.print(c);
    	}
    	System.out.println();
    }
	
	public static void main(String[] args) {
		char[] input = {'A','B','A'};
		perm(input, 0, input.length -1);

	}

}
