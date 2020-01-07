public class QuickSortWithLastPivot {

	public static void main(String[] args) {
		int[] arr= {10,5,8,12,50};
		quickSort(arr, 0, arr.length -1);

	}
	
	
	static void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int partitionIndex = partition(arr, low, high);
			print(arr, arr[partitionIndex], partitionIndex);
			
			quickSort(arr, low, partitionIndex -1);
			quickSort(arr, partitionIndex +1, high);
		}
	}
	

	
	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low -1;
		for(int j = low; j <= high -1;j++) {
			if(arr[j] <= pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1, high);
		return i+1;
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
