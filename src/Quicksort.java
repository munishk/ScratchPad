public class Quicksort {
	
	public static void main(String[] args) {
		int [] a = {100,89,5,20,30,4,2,7};
		for(int val: a) {
			System.out.print(val + " ");
		}
		System.out.println("");
		quickSort(a, 0, a.length -1);
	}
	
	private static void quickSort(int [] a, int low, int high) {
		if(low < high) {
			int pivot = a[(high + low)/2];
			int pivotIndex = partition1(a, low, high, pivot);
			print(a, pivot, pivotIndex);
			quickSort(a, low, pivotIndex);
			quickSort(a, pivotIndex+1, high);
		}
	}
	
	private static int partition1(int[] a, int low, int high, int pivot) {
		 int left = low;
		int right = high;
		while(left < right) {
			while(a[left] < pivot && left < right) left++;
			while(a[right] > pivot && right > left) right--;
			if(left < right) {
			swap(a, left, right);
			left++;
			right--;
			}
		}
		return left -1;
	}
	
	private static int partition(int[] array, int left, int right, int pivot) {
		
		while(left <= right) {
			if(array[left] > pivot) {
			swap(array, left, right);	
			right--;
			}else if(array[right] <= pivot) {
				swap(array, left, right);
				left++;
			}else {
				left++;
				right--;
			}
		}
		return left -1;
	}
	
	private static void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	private static void print(int[] array, int pivot, int pivotIndex) {
		StringBuilder strbuilder = new StringBuilder();
		for(int a: array) {
			strbuilder.append(a).append(' ');
		}
		strbuilder.append("pivot: ").append(pivot).append(" PivotIndex: ").append(pivotIndex);
		System.out.println(strbuilder);
	}

}
