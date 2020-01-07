public class Heap {
	
	int[] array;
	int index = -1;
	
	Heap(int size) {
		array = new int[size];
	}
	
	void insert(int element) {
		array[++index] = element;
		trickleUp(index);
		print();
	}
	
	int remove() {
		int temp = array[0];
		array[0] = array[index--];
		trickleDown();
		print();
		return temp;
	}

	void trickleDown() {
		int parentIndex = 0;
		int leftIndex = parentIndex * 2 +1;
		int rightIndex = parentIndex * 2 +2;
		while(rightIndex <= index && (array[parentIndex] < array[leftIndex] || array[parentIndex] < array[rightIndex] )) {
			int swapIndex;
			if(array[leftIndex] >= array[rightIndex]) {
				swapIndex = leftIndex;
			}else {
				swapIndex = rightIndex;
			}
			swap(parentIndex, swapIndex);
			parentIndex = swapIndex;
			leftIndex = parentIndex * 2 +1;
			rightIndex = parentIndex * 2 +2;
		}
	}
	
	void trickleUp(int index) {
		int currentIndex = index;
		int parentIndex = (currentIndex-1)/2;
		while(array[parentIndex] < array[currentIndex]) {
			swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = (currentIndex -1)/2;
		}
	}
	
	 void swap(int from, int to) {
		int temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}
	
	  void print() {
			StringBuilder str = new StringBuilder();
			for(int i=0; i <= index;i++) {
				str.append(array[i] + " ");
			}
			System.out.println(str);
		}
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(5);
		heap.insert(50);
		
		int removed = heap.remove();
		System.out.println("Removed:" + removed);
		
		removed = heap.remove();
		System.out.println("Removed:" + removed);

	}

}
