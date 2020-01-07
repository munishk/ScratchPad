public class DFADivision {
	
	static boolean isDivisible(int n, int k) {
		int[][] faTable = new int[k][2];
		preProcess(faTable, k);
		print(faTable);
		int finalState = isDivisibleUtil(n, 0, faTable);
		return finalState ==0;
	}
	
	static int  isDivisibleUtil(int n, int state, int[][] table) {
		if( n == 0) {
			return state;
		}else {
		 int prevState = isDivisibleUtil(n>>1, state, table);
		 	return table[prevState][n&1];
		}
	}
	
	static void print(int[][] table) {
		for(int i=0; i< table.length; i++) {
			System.out.println( i + "=>" + table[i][0] + " " + table[i][1]);
		}
	}
	
	static void preProcess(int[][] faTable, int k) {
		for(int state=0; state < k; state++) {
			int transitionZero = state<<1;
			faTable[state][0] = transitionZero < k ? transitionZero : transitionZero - k;
			int transitionOne = (state<<1) +1 ;
			faTable[state][1] = transitionOne < k ? transitionOne : transitionOne - k;
		}
	}

	public static void main(String[] args) {
		System.out.println(isDivisible(56, 7));
	}

}
