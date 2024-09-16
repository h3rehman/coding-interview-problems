package misc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), determine if a person could attend all meetings.
 *
 * Example 1:
 * Input:
 * [[0,30],[5,10],[15,20]]
 * Output:
 *  false
 *
 * Example 2:
 * Input:
 * [[7,10],[2,4]]
 * Output:
 *  true
 */
public class MeetingRooms {

    static boolean findMeetingPossibility(int[][] arr){
        //sort based on the starting time
        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        printArray(arr);
        int len = arr.length;
        for (int i=0; i<len-1; i++){
            if (arr[i][1] >= arr[i+1][0]){
                return false;
            }
        }
        return true;
    }
    static void printArray(int[][] arr){
        int len = arr.length;
        for (int i=0; i<len; i++){
            System.out.print(arr[i][0] + ", " + arr[i][1] + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][] {{7, 15}, {4, 9}, {0, 11}, {1, 2}};
        int[][] arr = new int[][] {{7, 15}, {4, 6}, {0, 3}, {18, 22}};
        boolean res = findMeetingPossibility(arr);
        System.out.println(res);
    }

}
