package tests;

import java.util.ArrayDeque;
import java.util.Arrays;

public class ArrayDequeExample {
	public static void main(String[] args) {
	      int[] a1 = {2, 1, 3, 4, 5};
	      ArrayDeque<Integer> c = new ArrayDeque<>();
	      for (int i : a1) {
	         c.push(i);
	      }
	      int[] a2 = new int[c.size()];
	      for (int i = 0; i < a2.length; i++) {
	      a2[i] = c.pop();
	      }
	      System.out.println(Arrays.toString(a2));
	   }
}
