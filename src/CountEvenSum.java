public class CountEvenSum {
	
	public static void main(String[] args) {
		int[] a= {1,2,2,3,4,1};
		System.out.println(countWithEvenSum(a));
	}

	
	private static int countWithEvenSum(int[] a) {
		int temp[] = {1,0};
		
		int sum = 0, result=0;
		for(int i =0; i < a.length; i++) {
			sum = (sum + i%2+2)%2;
			temp[sum]++;
		}
		
		for(int i: temp) {
			System.out.println(i);
		}
		
		result = result + (temp[0] * (temp[0]-1)/2);
		result = result + (temp[1] * (temp[1]-1)/2);
		return result;
	}
}
