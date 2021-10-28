package from100;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/11/2 16:20
 *  @Description 链表排序
 */
public class Solution148 {

    /**
     * 直接在链表上排序
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        ListNode sentry = new ListNode(Integer.MIN_VALUE);
        ListNode current;

        sentry.next = head;
        current = head;
        head = sentry;

        while (current != null && current.next != null) {
            ListNode tmp = current.next;

            if (current.next.val > current.val) {
                current = current.next;
                continue;
            }

            while (tmp.val > head.next.val) {
                head = head.next;
            }
            current.next = tmp.next;
            tmp.next = head.next;
            head.next = tmp;
            head = sentry;
        }

        return sentry.next;
    }

    /**
     * 自上而下归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // 递归停止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        return mid;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode sentry = new ListNode();
        ListNode current = sentry;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        current.next = (list1 == null) ? list2 : list1;

        return sentry.next;
    }
}
