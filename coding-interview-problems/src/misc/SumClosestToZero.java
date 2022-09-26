package misc;

import java.util.Arrays;

/**
 * An Array of integers is given, both +ve and -ve. Find the two elements such that their sum is closest to zero.
 */

public class SumClosestToZero {

    private static int[] findTwoClosestToZero(int [] nums){
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        int currentSum;
        int[] elements = new int[2];

        int i = 0;
        int j = nums.length-1;
        while(i < j){
            currentSum = nums[i] + nums[j];
            if (Math.abs(currentSum) < sum){
                sum = currentSum;
                elements[0] = nums[i];
                elements[1] = nums[j];
            }
            if (currentSum <= 0){
                i++;
            }
            else{
                j--;
            }
        }

        return elements;

    }

    public static void main(String[] args) {
        int[] nums = {1, 60, -10, 70, -80, 85};
        int[] elements = findTwoClosestToZero(nums);
        System.out.println("The elements are: ");
        for (int element : elements){
            System.out.print(element + " | ");
        }
    }

}
