package misc;

public class ShiftingLetters {

    /**
     * Original question: https://leetcode.com/problems/shifting-letters/
     * You are given a string s of lowercase English letters and an integer array shifts of the same length.
     * Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
     * For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
     * Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
     * Return the final string after all such shifts to s are applied.
     */

    static String shiftingLetters(String s, int[] shifts) {
        int len = s.length();
        char[] chars = s.toCharArray();

        for (int i=0; i<len; i++){
            int k = i;
            int x = shifts[i] % 26;
            while(k >= 0){
                char sh = (char) (chars[k]+x);
                chars[k]= sh > 'z' ? (char) ((sh % 'z')+ 96) : sh;
                k--;
            }
        }
        return String.valueOf(chars);
    }

//    public String shiftingLettersOnePass(String s, int[] shifts) {
//        int len = s.length();
//        long shift = 0;
//        for (int i = len-1; i>= 0; i--){
//            int x = (int) (((shifts[i] % 26) + shift) % 26);
//            char sh = (char) (s.charAt(i)+x);
//            s.charAt(i) = sh > 'z' ? (char) ((sh % 'z') + 96) : sh;
//            shift += shifts[i];
//        }
//        return s;
//    }

    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {300000, 40000755, 920};
        String result = shiftingLetters(s, shifts);
        System.out.println(result);

        String s2 = "aaa";
        int[] shifts2 = {1, 2, 3};
        String result2 = shiftingLetters(s2, shifts2);
        System.out.println(result2);

    }

}
