package from200;

import util.ListNode;

public class Solution203 {

    /**
     * 简单的链表删除，借助了哨兵结点方便操作
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode prev = sentry;

        while (head != null) {
            if (head.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = head;
            }

            head = head.next;
        }

        return sentry.next;
    }

    /**
     * 递归实现
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        // 对之后的链表进行处理
        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }
}
