package tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TestArray {

	public static void main(String[] args) {
		HashSet<Integer> nbrs = new HashSet<Integer>();
		
		for(int i = 0; i < 100; i+= 10) {
			nbrs.add(i);
			nbrs.add(i);
		}
		
		for(int a : nbrs) {
			System.out.println(a);
		}
	}
}
