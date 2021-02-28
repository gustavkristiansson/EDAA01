package sorting_algorithms;

public class MergeSort {
	

	public MergeSort() {
		
	}
	
	public static void sort(Object[] a) {
		Object[] tmpArray = new Object[a.length];
		mergeSort(a, tmpArray, 0, a.length - 1);
	}
	
	private static void mergeSort(Object [] a, Object[] tmpArray, int first, int last) {
		if(first < last) {
			int mid = first + (last - first) / 2;
			mergeSort(a, tmpArray, first, mid);
			mergeSort(a, tmpArray, mid + 1, last);
			merge(a, tmpArray, first, mid + 1, last);
		}
	}
	
	private static void merge(Object[] a, Object[] tmpArray,
			int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int leftStart = leftPos;
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if(((Comparable) a[leftPos]).compareTo(a[rightPos]) <= 0) {
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}
		while(leftPos <= leftEnd) {
			tmpArray[tmpPos++] = a[leftPos++];
		}
		while(rightPos <= rightEnd) {
			tmpArray[tmpPos++] = a[rightPos++];
		}
		for(int i = leftStart; i <= rightEnd; i++) {
			a[i] = tmpArray[i];
		}
	}
}
