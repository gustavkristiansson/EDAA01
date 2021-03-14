package ext20190821;

import java.util.HashMap;
import java.util.Map;

public class MapSparseVector implements SparseVector {
	Map<Integer, Double> map;
	private int length;
	
	MapSparseVector(int length) {
		map = new HashMap<>();
		this.length = length;
	}
	
	/**
	* Puts val in element with index i.
	* @param i index
	* @param val the new value
	* @throws IllegalArgumentException if i < 0 or >= the length of this vector
	*/
	@Override
	public void put(int i, double val) {
		if(i < 0 || i >= length) {
			throw new IllegalArgumentException();
		} 
		if(val == 0) {
			map.remove(i);
		} else {
			map.put(i, val);
		}
	}
		

	/**
	* Gets the value in the element with index i.
	* @param i index
	* @return the value in the element with index i
	* @throws IllegalArgumentException if i < 0 or >= the length of this vector
	*/
	@Override
	public double get(int i) {
		if(i < 0 || i >= length) {
			throw new IllegalArgumentException();
		} else {
			Double d = map.get(i);
			if(d == null) {
				return 0.0;
			} else {
				return d;
			}
		}
	}

	@Override
	public int length() {
		return length;
	}

	/**
	* Computes the dot product of this vector and v.
	* @param v the other vector
	* @return the dot product
	* @throws IllegalArgumentException if the two vectors have different length
	*/
	public double dot(SparseVector v) {
		if(length != v.length()) {
			throw new IllegalArgumentException();
		}
		double sum = 0;
		
		for(Map.Entry<Integer, Double> e: map.entrySet()) {
			sum += e.getValue() * v.get(e.getKey());
		} 
		return sum;
	}

}
