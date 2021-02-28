package sorting_algorithms;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer[] nbrs = {84,25,12,76,9,35};
		System.out.println(Arrays.toString(nbrs));
		
		int N = 500;
		
		for(int i = 0; i < N; i++) {
		
		double start = System.nanoTime();
		MergeSort.sort(nbrs);
		double finish = System.nanoTime();
		
		double res = finish - start;
		
		System.out.println(Arrays.toString(nbrs) + " " + res);
		}

	}

}
