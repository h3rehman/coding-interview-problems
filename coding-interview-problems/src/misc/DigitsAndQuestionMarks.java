package misc;

/**
 * Have the function questionsMarks(str) take the str string parameter, which will contain single digit numbers, lowercase letters,
 * and question marks, and check if there are exactly 3 question marks between every pair of two numbers that add up to 10.
 * If so, then your program should return the string true, otherwise it should return the string false.
 * If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.
 *
 * For example:
 * if str is "arrb6???4xxbl5???eee5" then your program should return true
 * because there are exactly 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.
 */
public class DigitsAndQuestionMarks {

    static boolean questionMarks(String str){
        int i=0;
        int n = str.length();
        char[] chars = str.toCharArray();

        while (i < n) {
            if (chars[i] < 'a' && chars[i] != '?') {
                int j = i + 1;
                int counter = 0;

                while (j < n) {
                    if (counter == 3 && chars[j] < 'a' && chars[j] != '?') {
                        int digit1 = Character.getNumericValue(chars[i]);
                        int digit2 = Character.getNumericValue(chars[j]);
                        if (digit1 + digit2 != 10)
                            return false;
                        else {
                            i = j;
                            break;
                        }
                    }
                    if (chars[j] == '?') {
                        counter++;
                    }
                    if (counter > 3)
                        return false;
                    j++;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
//        String str = "arrb6???4xxbl5???eee5sdkf????jhs8kj?hs?aasder?a2sdfsd??????????";
        String str = "arrb6???4xxbl5???eee5";
        boolean answer = questionMarks(str);
        System.out.println("The Answer is:");
        System.out.println(answer);
    }

}
