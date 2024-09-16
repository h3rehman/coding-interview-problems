package algos;

import javax.crypto.spec.PSource;

public class BinarySearch {

    /**
     * For Binary Search, always confirm if the input array is sorted.
     */

    static int binarySearch(int hi, int mid, int lo, int len, int[] arr, int target){
        if (lo > hi || lo < 0 || hi > len-1){ return -1; }
        if (arr[mid] == target){ return mid; }
        if (mid == 0 || mid == len-1) { return -1; }
        if (target > arr[mid]){ lo = mid+1; }
        else{ hi = mid-1; }
        mid = (lo+hi)/2;
        return binarySearch(hi, mid, lo, len, arr, target);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,4,6,9,10,11,12};
        int target = 2;
        int len = arr.length;
        int hi = len-1;
        int lo = 0;
        int mid= (hi+lo)/2;
        int result = binarySearch(hi, mid, lo, len, arr, target);
        String msg = result != -1 ? "Target is at index: " + result : "Target " + target + " is not found.";
        System.out.println(msg);
    }

}
