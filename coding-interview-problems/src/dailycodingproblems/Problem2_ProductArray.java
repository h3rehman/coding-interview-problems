package dailycodingproblems;

/**
 * This problem was asked by Uber.
   Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
   For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

   Follow-up: what if you can't use division?
 * @author RehmanH
 * 
 * [1, 2, 3, 4, 5]
 * 
 *
 */

public class Problem2_ProductArray {
	
	//Takes O(n^2) time. 
	static int[] naiveProductArray(int[] A) {
		int size = A.length;
		if (size == 1) return A;
		int[] B = new int[size];
		int product = 1;
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (j != i) product*= A[j];
			}
			B[i] = product;
			product = 1;
		}
		return B;
	}

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		int[] res = naiveProductArray(A);
		
		for (int i=0; i<res.length; i++)
			System.out.print(res[i] + " ");
		
	}

}
