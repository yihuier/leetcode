package from1;

import util.ListNode;

import java.util.Stack;

/**
 *  @author yihuier
 *  @Date 2020/11/4 17:52
 *  @Description 使用一个stack来保存需要转置的节点
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode prev = sentry;
        ListNode next;
        int num = 1;

        while (num < m && head != null) {
            prev = prev.next;
            head = head.next;
            num++;
        }

        while (num <= n && head != null) {
            stack.push(head);
            head = head.next;
            num++;
        }
        next = head;

        while (!stack.isEmpty()) {
            prev.next = stack.pop();
            prev = prev.next;
        }

        if (prev != null) {
            prev.next = next;
        }

        return sentry.next;
    }
}
