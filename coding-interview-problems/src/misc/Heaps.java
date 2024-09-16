package misc;

import java.util.*;

public class Heaps {

    static int[] arr = new int[]{90, 17, 20, 21, 32, 15};

    static void minHeapInsert(int pos, int len) {
        Integer x = null;
        if ((pos*2)+1 < len && arr[(pos*2)+1] < arr[pos]){
            x = (pos*2)+1;
        }
        if ((pos*2)+2 < len && arr[(pos*2)+2] < arr[(pos*2)+1] && arr[(pos*2)+2] < arr[pos]){
            x = (pos*2)+2;
        }
        if (x != null){
            swap(x, pos);
            minHeapInsert(x, len);
        }
    }
    static void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static void printArray(){
        int len = arr.length;
        for (int i=0; i<len; i++){
            System.out.print(arr[i] + " | ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        printArray();
//        minHeapInsert();
//        printArray();
        int x = 1;
        int y = 2;
        Stack<int[]> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add(x + "" + y);
        boolean res = set.contains("12");
        System.out.println(res);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        System.out.println("List 1: " + list1);

        List<Integer> list2 = new ArrayList<>(list1);
        list2.add(3);
        System.out.println("List 2: " + list2);

        List<Integer> list3 = list1;
        list3.add(4);
        System.out.println("List 3: " + list3);
        System.out.println("List 1: " + list1);


    }
}
