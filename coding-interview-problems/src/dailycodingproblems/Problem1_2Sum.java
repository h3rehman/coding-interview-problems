package dailycodingproblems;

import java.util.Arrays;

/**
 * Given a list of numbers, return whether any two sums to k. 
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17. 
 * Bonus: Can you do this in one pass?
 * @author RehmanH
 *
 */

public class Problem1_2Sum {
	
	
	static boolean better2Sum(int[] A, int k) {
		int size = A.length;
		if (size < 2) return false;
		Arrays.sort(A);
		int i=0;
		int j= size-1;
		
		int sum = 0;
		while (i < j) {
			sum = A[i] + A[j];
			
			if (sum == k) {
				System.out.println(A[i] + " " + A[j]);
				return true;
			}
			
			if (sum < k) i++;
			else j--;			
		}
		
		return false;
	}
	
	static boolean naive2Sum(int[] A, int k) {
		int size = A.length;
		
		if (size < 2) return false;
		
		for (int i=0; i<size-1; i++) {
			for (int j=1; j<size; j++) {
				if (A[i] + A[j] == k) {
					System.out.println(A[i] + " " + A[j]);
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
//		int[] A = {10, 15, 3, 7};
//		int[] A = {100, 15, 3, 6, 72, -500, 7};
		int[] A = {20, -2, 90, 32};
		int k=30;
		boolean res = naive2Sum(A, k);
		System.out.println(res);
		
		boolean res2 = better2Sum(A, k);
		System.out.println(res2);
	}

}
