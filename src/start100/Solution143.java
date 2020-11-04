package start100;

import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  @author yihuier
 *  @Date 2020/11/4 23:20
 *  @Description
 */
public class Solution143 {

    /**
     * 借助双端队列，很容易实现但效率较低
     */
    public void reorderList1(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode sentry = new ListNode();

        while (head != null) {
            deque.addLast(head);
            head = head.next;
        }

        while (!deque.isEmpty()) {
            sentry.next = deque.removeFirst();
            sentry = sentry.next;
            if (!deque.isEmpty()) {
                sentry.next = deque.removeLast();
                sentry = sentry.next;
            }
        }

        sentry.next = null;
    }

    /**
     * 将链表分成两部分，后半部分先转置，然后再将两部分结点分别连接
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // 找出右半部分的第一个结点，此时的slow为中间结点，所以slow.next为右半部分的第一个结点
        ListNode right = slow.next;
        slow.next = null;

        // 将右半部分转置
        ListNode current = right.next;
        // 这里要注意，因为转置之后该结点为作为最后一个结点，所有要将next置为null
        right.next = null;
        ListNode tmp;
        while (current != null) {
            tmp = current.next;
            current.next = right;
            right = current;
            current = tmp;
        }

        // 同时遍历左右两部分，连接成新链表
        current = head;
        while (right != null) {
            tmp = current.next;
            current.next = right;
            right = right.next;
            current.next.next = tmp;
            current = tmp;
        }
    }
}
