package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingRoomsLC252 {
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

    static boolean meetingsPossible(int[][] intervals){
        if (intervals == null || intervals.length == 0) return false;

        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        Collections.sort(list, (a,b) -> Integer.compare(a[0], b[0]));
        int curr = list.get(0)[1];
        for (int i=1; i<list.size(); i++){
            if (curr >= list.get(i)[0]) return false;
            curr = list.get(i)[1];
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30}, {5,10},{15,20}};
        boolean res = meetingsPossible(intervals);
        System.out.println("Result " + res);

        intervals = new int[][]{{7,10}, {2,4}};
        res = meetingsPossible(intervals);
        System.out.println("Result " + res);

        intervals = new int[][] {{7, 15}, {4, 6}, {0, 3}, {18, 22}};
        res = meetingsPossible(intervals);
        System.out.println("Result " + res);
    }


}
