package from100;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/11/5 16:36
 *  @Description
 */
public class Solution142 {

    /**
     * 判断链表中是否有换，如果有环则找出环的入口
     * 经过一波分析，快慢指针相遇点到环的入口和从起点到环的入口距离相等
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode cur = head;

        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }

        return cur;
    }
}
