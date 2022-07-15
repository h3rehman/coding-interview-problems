package introductiontoalgorithms.ch15dynammicprogramming;

/**
 * 15.1 Given a rod of length n inches and a table of prices Pi for i=1,2,...,n, determine the maximum
 * revenue obtainable by cutting the rod and selling the pieces. Note that if the price Pn for a rod of
 * length n is large enough, an optimal solution may require no cutting at all.
 */

public class RodCuttingProblem {

    //index is the length: 0, 1, 2, 3, 4, 5,  6,  7,  8,  9,  10
    static int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    static int getOptimalRevenueForGivenLength(int[] prices, int rodLength){
        int len = prices.length;
        int[][] dp = new int[len+1][len+1];
        for (int i=1; i<=rodLength; i++){
            int x = 0;
            while(x < i){
                dp[i][x] = dp[i-1][x];
                x++;
            }
            for (int j=i; j<=rodLength; j++){
                dp[i][j] = Math.max(dp[i-1][j], prices[i] + dp[i][j-i]);
            }
        }
        return dp[rodLength][rodLength];
    }

    static int[][] getOptimalRevenueForAllLengths(int[] prices){
        int len = prices.length;
        int[][] dp = new int[len][len];
        for (int i=1; i<len; i++){
            int x=0;
            while(x < i){
                dp[i][x] = dp[i-1][x];
                x++;
            }
            for(int j=i; j<len; j++){
                dp[i][j] = Math.max(dp[i-1][j], prices[i] + dp[i][j-i]);
            }
        }
        return dp;
    }


    public static void main(String[] args) {

        int rodLength = 7;
        System.out.println("Optimal revenue for length " + rodLength + ": " + getOptimalRevenueForGivenLength(prices, rodLength));

        int[][] dp = getOptimalRevenueForAllLengths(prices);
        System.out.println("Optimal Revenue for All Lengths: ");
        System.out.print("  | ");
        for (int i=0; i<dp.length; i++){
            System.out.print(i + " | ");
        }
        System.out.println();

        for (int i=0; i<dp.length; i++){
            System.out.print(prices[i] + " | ");
            for (int j=0; j<dp.length; j++){
                System.out.print(dp[i][j] + " | ");
            }
            System.out.println();
        }
    }

}