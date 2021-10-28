package from800;

import util.ListNode;

public class Solution867 {

    /**
     * 找链表中间位置，快慢指针很方便
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
