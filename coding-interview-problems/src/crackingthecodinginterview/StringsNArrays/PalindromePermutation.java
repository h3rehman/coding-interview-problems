package crackingthecodinginterview.StringsNArrays;

/**
 * Given a string, write a function to check if it is a permutation of a Palindrome. 
 * A Palindrome is a word or phrase that is the same forwards and backwards. 
 * A permutation is a rearrangement of letters.  
 * @author RehmanH
 *
 */

public class PalindromePermutation {

	
	/**
	 * ijackcaji
	 * ujujujuju
	 * chaddahc
	 * ccchhhccc
	 * ttttttaiaatttttt
	 * pdadp
	 */
	
	static boolean checkPalin(String str) {
		
		boolean oddCheck = false; 
		int size = str.length();
		if (size%2 == 1) oddCheck = true;
		
		int[] A = new int[128];
		
		for (int i=0; i<size; i++)
			A[str.charAt(i)]++;			
		
		if (oddCheck) {
			boolean check1 = false;
			for (int i=0; i<128; i++) {
				if (A[i] == 1) {
					if (check1) return false;
					else check1 = true;
				}
			}
		}
		else {
			for (int i=0; i<128; i++) {
				if (A[i] == 1) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		/**
		 * ijackcaji
		 * ujujujuju
		 * chadyedahc
		 * ccchhhccc
		 * ttttttaiaatttttt
		 * pdadp
		 */
		
		String str = "AcA";
		boolean res = checkPalin(str);
		
		System.out.println(res);
	}

}
