package introductiontoalgorithms.ch15dynammicprogramming;

import java.util.Stack;

/**
 * 15.4 Given two strings, find the longest common subsequence.
 */

public class LongestCommonSubsequence {

    static String A = "ABCBDAB";
    static String B = "BDCABA";

    static int[][] findLongestCommonSubsequence(){
        int[][] dp = new int[A.length()+1][B.length()+1];
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        for (int i=1; i<=A.length(); i++){
            for (int j=1; j<=B.length(); j++){
                if (arrA[i-1] == arrB[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp;
    }

    static String printLongestCommonSubsequence(int[][] dp){
        int i = A.length();
        int j = B.length();
        Stack<Character> stack = new Stack<>();
        while (i > 0 && j > 0){
            if (dp[i][j] > dp[i-1][j] && dp[i][j] > dp[i][j-1]){
                stack.push(A.charAt(i-1));
                i--;
                j--;
            }
            else {
                if (dp[i-1][j] >= dp[i][j-1]) i--;
                if (dp[i][j-1] > dp[i-1][j]) j--;
            }
        }
        String lcs = "";
        while(!stack.empty()){
            lcs+=stack.pop();
        }
        return lcs;
    }

    public static void main(String[] args) {
        System.out.println("Longest common subsequence table: ");

        int[][] dp = findLongestCommonSubsequence();

        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Longest common subsequence in A and B: ");
        String lcs = printLongestCommonSubsequence(dp);
        System.out.println(lcs);
    }

}
