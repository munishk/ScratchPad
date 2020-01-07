/**
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 * @author MUNISHK
 *
 */
public class Combination {
	
	/*
	 * In this method, we first fix first element and recur for rest of element. For example, if input is {1,2,3,4,5} and k =3
	 * start - start index for array
	 * end - end of input array
	 * index - current index in temp array
	 * k - number of element in combination
	 */
	static void combinationFixAndRecur(int[] arr, int[] temp, int start, int end, int index, int k) {
		if(index == k) {
			print(temp);
			return;
		}
		
		for(int i= start; i + k - index - 1 <= end ;i++) {
			temp[index] = arr[i];
			combinationFixAndRecur(arr, temp, i+1, end, index+1, k);
		}
	}
	
	/*
	 * In this method, at every step, we either include that element or exclude that element.
	 * n - length of input array
	 * k - size of required combination
	 * index - current index in temp array
	 * i - index of current element in array
	 */
	static void combinationIncludeExclude(int[] arr, int[] temp, int n, int k, int index, int i) {
		if(index == k) {
			print(temp);
			return;
		}
		
		if(i > n) {
			return;
		}
		
		temp[index] = arr[i];
		combinationIncludeExclude(arr, temp, n, k, index+1, i+1);
		
		combinationIncludeExclude(arr, temp, n, k, index, i+1);
		
	}

	static void print(int[] arr) {
		for(int val: arr) {
			System.out.print(val + " " );
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k =3;
		int[] temp = new int[k];
		System.out.println("Using Fix and Recur method:");
		combinationFixAndRecur(arr, temp, 0, arr.length -1, 0, k);
		
		System.out.println("Using Include/Exclude method:");
        combinationIncludeExclude(arr, temp, arr.length -1, k, 0, 0);
	}

}
