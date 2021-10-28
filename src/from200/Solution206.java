package from200;

import util.ListNode;

public class Solution206 {

    /**
     * 普通做法
     */
    public ListNode reverseList2(ListNode head) {
        ListNode current = null;

        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = current;
            current = node;
        }

        return current;
    }

    /**
     * 递归
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}
