package linkedlist;

public class LeetCode206 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        System.out.println(new LeetCode206().reverseList1(listNode));
//        System.out.println(new LeetCode206().reverseList(listNode));
    }

    public ListNode reverseList(ListNode head) {

        // 1 -> 2 -> 3 -> null
        // 3 -> 2 -> 1 -> null
        // ListNode
        if (head == null) {
            return null;
        }

        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }

    public ListNode reverseList1(ListNode head) {
        // 1 -> 2 -> 3 -> null
        // 3 -> 2 -> 1 -> null

        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
