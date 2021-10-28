package from1;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/11/9 15:28
 *  @Description
 */
public class Solution23 {

    /**
     * 很常规的解法，毫无亮点可言
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        ListNode result = null;
        for (ListNode head : lists) {
            result = merge(result, head);
        }

        return result;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode sentry = new ListNode();
        ListNode cur = sentry;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;

        return sentry.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return division(lists, 0, lists.length - 1);
    }

    /**
     * 分组合并排序，类似归并排序
     */
    private ListNode division(ListNode[] lists, int from, int to) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (to == from) {
            return lists[from];
        }

        int mid = (from + to) / 2;
        ListNode left = division(lists, from, mid);
        ListNode right = division(lists, mid + 1, to);

        return merge(left, right);
    }
}
