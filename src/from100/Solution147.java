package from100;

import util.ListNode;


/**
 *  @author yihuier
 *  @Date 2020/11/3 19:05
 *  @Description
 */
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 虽然很不喜欢给哨兵结点一个最小值，但还是这么做了
        ListNode sentry = new ListNode(Integer.MIN_VALUE);
        sentry.next = head;
        head = sentry;
        ListNode last = head;
        ListNode current = head.next;

        while (current != null) {
            ListNode tmp = head;

            if (current.val >= last.val) {
                last = current;
                current = current.next;
                continue;
            }

            while (current.val >= tmp.next.val) {
                tmp = tmp.next;
            }

            last.next = current.next;
            current.next = tmp.next;
            tmp.next = current;
            current = last.next;
        }

        return head.next;
    }
}
