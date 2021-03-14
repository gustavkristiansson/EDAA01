package ext20190821;

public interface SparseVector {
	
	/**
	* Puts val in element with index i.
	* @param i index
	* @param val the new value
	* @throws IllegalArgumentException if i < 0 or >= the length of this vector
	*/
	void put(int i, double val);
	
	/**
	* Gets the value in the element with index i.
	* @param i index
	* @return the value in the element with index i
	* @throws IllegalArgumentException if i < 0 or >= the length of this vector
	*/
	double get(int i);
	
	/**
	* Returns the length of this vector.
	* @return the length of this vector
	*/
	int length();
	
	/**
	* Computes the dot product of this vector and v.
	* @param v the other vector
	* @return the dot product
	* @throws IllegalArgumentException if the two vectors have different length
	*/
	double dot(SparseVector v);

}
