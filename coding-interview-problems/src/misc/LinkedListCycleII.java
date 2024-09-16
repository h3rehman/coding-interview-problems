package misc;

public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slowNode = head.next;
        ListNode fastNode = null;

        if (head.next != null) {
            fastNode = head.next.next;
        }

        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) {
                return fastNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return null;
    }

    public static void main(String[] args) {
     ListNode head = new ListNode(3);
     ListNode cycleNode = new ListNode(2);
     head.next = cycleNode;
     head.next.next = new ListNode(0);
     head.next.next.next = new ListNode(-4);
     head.next.next.next.next = cycleNode;

     ListNode result = detectCycle(head);
    System.out.println("Node has cycle for:  " + result.val);
 }

}
