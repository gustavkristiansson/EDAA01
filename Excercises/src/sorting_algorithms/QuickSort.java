package sorting_algorithms;

public class QuickSort {
	
	public QuickSort() {
		
	}
	
	public static void sort(Object[] a) {
		quickSort(a, 0, a.length - 1);
	}
	
	private static int partition(Object[] a, int first, int last) {
		return 0;
	}
	
	private static void quickSort(Object[] a, int first, int last) {
		if(first < last) {
			int pivIndex = partition(a, first, last);
			quickSort(a, first, pivIndex - 1);
			quickSort(a, pivIndex + 1, last);
		}
	}

}
