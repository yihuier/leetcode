package start1;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/11/6 15:27
 *  @Description 使用一个标志变量来标志当前结点的值是否已经重复
 */
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode pre = sentry;
        ListNode cur = head;
        ListNode next = head.next;
        boolean isDuplicate = false;

        while (next != null) {
            if (cur.val != next.val) {
                if (!isDuplicate) {
                    pre = cur;
                    cur = next;
                    next = next.next;
                } else {
                    pre.next = next;
                    cur = next;
                    next = next.next;
                    isDuplicate = false;
                }
                continue;
            }

            pre.next = next;
            cur = next;
            next = next.next;
            isDuplicate = true;
        }

        if (isDuplicate) {
            pre.next = next;
        }

        return sentry.next;
    }
}
