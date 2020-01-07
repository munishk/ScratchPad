public class Count2s {

	public static void main(String[] args) {
		System.out.println(count2s(12));

	}
	
	private static int count2s(int number) {
		int count = 0;
		for(int i=0; i < String.valueOf(number).length(); i++) {
			count+=count2s(number, i);
		}
		return count;
	}
	
	private static int count2s(int number, int d) {
		int powerOfTen = (int) Math.pow(10, d);
		int nextPowerofTen = powerOfTen * 10;
		
		int right = number%powerOfTen;
		
		int roundDown = number  - number%10;
		int roundUp = roundDown +nextPowerofTen;
		
		int digit = (number/powerOfTen) %10;
		
		if(digit < 2) {
			return roundDown/10;
		}else if (digit == 2) {
			return roundDown/10 + right + 1;
		}else {
			return roundUp/10;
		}
		
	}

}
