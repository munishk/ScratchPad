public class MergeSort {

	public static void main(String[] args) {
		int[] array = {15,12,8,20,25};
		print(array);
		int[] helper = new int[array.length];
		mergeSort(array, 0, array.length -1, helper);
        print(array);
	}
	
	static void print(int[] array) {
		StringBuilder str = new StringBuilder();
		for(int val : array) {
			str.append(val + " ");
		}
		System.out.println(str);
	}

	static void mergeSort(int[] array, int low, int high, int[] helper) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(array, low, mid, helper);
			mergeSort(array, mid + 1, high, helper);
			merge(array, low, mid + 1, high, helper);
		}
	}

	static void merge(int[] array, int low, int mid, int high, int[] helper) {
		for(int i=low; i<= high;i++) {
			helper[i] = array[i];
		}
		
		int left = low;
		int right = mid;
		int current = low;
		while (left <= mid && right <= high) {
			if (helper[left] <= helper[right]) {
				array[current++] = helper[left];
				left++;
				}else {
					array[current++] = helper[right];
					right++;
				}
		}
		
		for(int i=left; i<mid;i++) {
			array[current++] = helper[i];
		}
	}

	static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
