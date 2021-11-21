package linkedlist;

public class Solution3Debug {
    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = new Solution3Debug().removeElements(head, 6, 0);
        System.out.println(res);
    }

    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.println(depthString + "Call: remove " + val + " in " + head);
        if (head == null) {
            System.out.println(depthString + "Return: " + null);
            return null;
        }


        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.println(depthString + "After remove " + val + ": " + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.println(depthString + "Return: " + ret);
        return ret;
    }


    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("\t");
        }
        return res.toString();
    }

}
