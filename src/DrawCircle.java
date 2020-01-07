public class DrawCircle {
	
	static void drawCircle(int r) {
		int n = 2*r+1;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j <n;j++) {
				int x = i-r;
				int y = j-r;
				if(x*x + y*y <= r*r +1) {
					System.out.print('.');
				}else {
					System.out.print(' ');
				}
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		drawCircle(2);

	}

}
