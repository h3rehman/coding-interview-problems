package crackingthecodinginterview.StringsNArrays;
/**
 * Given two strings write a method to decide if one is a permutation of the other. Assume these are ASCII characters. 
 * @author RehmanH
 *
 */
public class CheckPermutation {
	
	static boolean checkPerm(String str1, String str2) {
		int size1 = str1.length();
		int size2 = str2.length();
		
		if (size1 != size2) return false;
		
		int val1 = 0;
		int val2 = 0;
		for (int i=0; i<size1; i++) {
			val1+=str1.charAt(i);
			val2+=str2.charAt(i);
		}
		System.out.println("Val 1:" + val1 + " Val 2:" + val2);
		if (val1 == val2) return true;
		else return false;
	}

	public static void main(String[] args) {
		
//		String str1 = "rattle";
//		String str2 = "tartle";
		
		String str1 = "SHO09rattle";
		String str2 = "90tOarStleH";
		
		boolean res = checkPerm(str1, str2);
		
		System.out.println(res);

	}

}
