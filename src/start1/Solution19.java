package start1;

import util.ListNode;

public class Solution19 {

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) return null;

        ListNode sentry = new ListNode(0);
        sentry.next = head;

        // fast比slow先走n步，那么当fast到达最后一个结点的时候，slow的后一个结点刚好是倒数第n个
        ListNode fast = sentry;
        ListNode slow = sentry;

        // 因为保证了输入的n的合法性，所以这里不对fast是否为null进行判断
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        // 这里以fast是否到达最后一个结点为循环条件
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return sentry.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode sentry = new ListNode(0);
        sentry.next = head;

        ListNode fast = sentry;
        ListNode slow = sentry;

        // 这里fast比slow先走n+1步，那么当fast为null的时候，slow的后一个结点刚好在倒数第n个
        while (n >= 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return sentry.next;
    }
}
