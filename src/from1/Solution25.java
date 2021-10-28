package from1;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/11/8 10:54
 *  @Description 分组处理，需要注意每一次分组之后头尾结点与整个链表的连接
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentry = new ListNode();
        sentry.next = head;
        ListNode cur = head;
        ListNode lastTail = sentry;

        while (cur != null) {
            int count = 1;
            ListNode curHead = cur;
            while (count < k && cur != null) {
                cur = cur.next;
                count++;
            }

            // 最后剩下的个数不足的结点忽略
            if (cur == null) {
                break;
            }

            ListNode last = cur.next;
            cur.next = null;

            // 转置之后，新旧头尾结点处理
            reverse(curHead);
            lastTail.next = cur;
            curHead.next = last;
            lastTail = curHead;
            cur = last;
        }

        return sentry.next;
    }

    private void reverse(ListNode head) {
        ListNode newHead = null;
        ListNode tmp;

        while (head != null) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
    }
}
