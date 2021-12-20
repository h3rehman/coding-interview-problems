package dailycodingproblems;

import java.util.HashSet;

/**
 * This problem was asked by Stripe.
 * Given an array of integers, find the first missing positive integer in linear time and constant space. 
 * In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 * You can modify the input array in-place.
 * 
 * @author RehmanH
 *
 */

public class Problem4_FirstMissing {
	
	
	static int firstPosMissing(int[] A) {
		int size = A.length;
		
		if (size < 1) {
			System.out.println("Array is empty.");
			return -1;
		}
		int lowest = Integer.MAX_VALUE;
		HashSet<Integer> set = new HashSet<>();
		for (int i=0; i<size; i++) {
			if (A[i] > 0) {
				set.add(A[i]);
				if (A[i] < lowest) {
					lowest = A[i];
				}
			}
		}
		
		if (lowest != 1) return 1;
		
		int k;
		for (k=2; k<=set.size(); k++) {
			if (!set.contains(k)) {
				return k;
			}
		}
				
		return k;
	}

	public static void main(String[] args) {
//		int[] A = {3, 4, -1, 1, 2};
//		int[] A = {3, 4, -1, 2};
		int[] A = {3, 2, 4, 8, -1, 1, 0};
		int res = firstPosMissing(A);
		System.out.println("Lowest missing positive: " + res);
	}

}
