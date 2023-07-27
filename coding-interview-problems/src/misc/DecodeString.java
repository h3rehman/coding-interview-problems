package misc;

public class DecodeString {

    /**
     * Original question: https://leetcode.com/problems/decode-string
     * Given an encoded string, return its decoded string.
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
     * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
     * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
     * The test cases are generated so that the length of the output will never exceed 105.
     */

    static String decodeStringRecursive(String s){
        int len = s.length();
        if (len == 1 && Character.isDigit(s.charAt(0))) return "";
        char[] sChars = s.toCharArray();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i < len){
            if (Character.isDigit(sChars[i])){
                String num = String.valueOf(s.charAt(i));
                int z = i+1;
                while(Character.isDigit(s.charAt(z))){
                    num += s.charAt(z);
                    z++;
                }
                if (num.length() > 1) {
                    i = z-1;
                }
                int y = getSubStringLastIndex(i+2, s, len);
                sb.append(expandString(Integer.parseInt(num), s.substring(i+2, y)));
                i = y;
            }
            else if (sChars[i] >= 'a'){
                sb.append(sChars[i]);
            }
            i++;
        }
        return sb.toString();
    }

    static String expandString(int digit, String s){
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int x=0;
        while(x<len){
            if (Character.isDigit(s.charAt(x))){
                String num = String.valueOf(s.charAt(x));
                int z = x+1;
                while(Character.isDigit(s.charAt(z))){
                    num += s.charAt(z);
                    z++;
                }
                if (num.length() > 1) {
                    x = z-1;
                }
                int y = getSubStringLastIndex(x+2, s, len);
                sb.append(expandString(Integer.parseInt(num), s.substring(x+2, y)));
                x = y;
            }
            else if (s.charAt(x) >= 'a'){
                sb.append(s.charAt(x));
            }
            x++;
        }
        String base = sb.toString();
        int n=1;
        while(n<digit){
            sb.append(base);
            n++;
        }
        return sb.toString();
    }

    static int getSubStringLastIndex(int i, String s, int len){
        int k=1;
        while(i<len){
            if (s.charAt(i) == ']') k--;
            if (s.charAt(i) == '[') k++;
            if (k == 0) break;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        String input = "1[bc2[az3[kl]300[plcq45[fq]]]]";
        String input2 = "3[a]2[bc]";
        String input3 = "4[bc3[az2[mn]]k]";
        System.out.println(decodeStringRecursive(input));
        System.out.println(decodeStringRecursive(input2));
        System.out.println(decodeStringRecursive(input3));
    }

 }
