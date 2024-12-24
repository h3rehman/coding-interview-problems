package misc;

import java.util.*;

public class MeetingRoomsII {
    /**
     * Leetcode: 253 Meeting Rooms II
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     */

    private static int minimumMeetingRooms(int[][] intervals){
        if (intervals == null || intervals.length == 0) return 0;
        int count = 1;
        int len = intervals.length;

        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        printArray(list);
        Collections.sort(list, Comparator.comparingInt(a -> a[0]));
        printArray(list);

        int curr = list.get(0)[1];
        for (int i=1; i<len; i++){
            if (curr >= list.get(i)[0]) count++;
            curr = list.get(i)[1];
        }
        return count;
    }

    static void printArray(List<int[]> intervals){
        for (int i=0; i<intervals.size(); i++){
            for (int j=0; j<intervals.get(i).length; j++){
                System.out.print(intervals.get(i)[j] + ",");
            }
            System.out.print(" | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30}, {5,10}, {15,20}};
        int res = minimumMeetingRooms(intervals);
        System.out.println("Result " + res);

        intervals = new int[][]{{7,10}, {2,4}};
        res = minimumMeetingRooms(intervals);
        System.out.println("Result " + res);
    }

}
