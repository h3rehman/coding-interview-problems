package misc;

/**
 * Search max value in an unsorted array in better than O(n)
 */
public class LinearSearch {
    /**
     * Following two pointer approach, so worst case is n/2;
     */
    static int findMaxValue(int[] arr){
        int len = arr.length;
        if (len < 2 && len > 0){
            return arr[0];
        }
        int i = 0;
        int j = len-1;
        int max = arr[0];
        while(i <= j){
            max = Math.max(arr[i], max);
            max = Math.max(arr[j], max);
            i++;
            j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 9, -1, 20, 17, 11, 6, 12, 18, 29, 14, 3};
        int result = findMaxValue(arr);
        System.out.println("Max Value: " + result);
    }

}
