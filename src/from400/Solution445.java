package from400;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/9/11 14:27
 *  @Description 两个用链表表示的非负数相加
 *  先计算两个链表的节点个数差，然后用值为0的节点进行补充，使两个链表节点个数相同
 *  然后遍历链表进行两个链表相加（此时不进行进位处理），新的链表是以低位为头结点
 *  再遍历新链表，并进行进位处理，最后对新链表进行反转
 *  由于新链表的头结点可能是一个值为0的节点（没有进位的时候为0），所以需要进行判断，
 *  最后返回链表
 */
public class Solution445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Count = 0;
        int l2Count = 0;

        ListNode l1Head = l1;
        ListNode l2Head = l2;

        while (l1 != null) {
            l1Count++;
            l1 = l1.next;
        }

        while (l2 != null) {
            l2Count++;
            l2 = l2.next;
        }

        int diff = Math.abs(l1Count - l2Count);
        ListNode appendHead = new ListNode();
        ListNode current = appendHead;
        while (diff > 0) {
            current.next = new ListNode(0);
            current = current.next;
            diff--;
        }

        if (l1Count < l2Count) {
            current.next = l1Head;
            l1Head = appendHead.next;
        } else {
            current.next = l2Head;
            l2Head = appendHead.next;
        }

        current = new ListNode(0);
        while (l1Head != null && l2Head != null) {
            ListNode tmp = new ListNode(l1Head.val + l2Head.val);
            tmp.next = current;
            current = tmp;

            l1Head = l1Head.next;
            l2Head = l2Head.next;
        }

        ListNode head = current;
        while (current.next != null) {
            if (current.val > 9) {
                current.next.val += 1;
                current.val -= 10;
            }

            current = current.next;
        }

        current = head;
        ListNode prev = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        if (head.val == 0) {
            return head.next;
        }

        return head;
    }
}
