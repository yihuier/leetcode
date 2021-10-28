package from300;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/9/10 10:38
 *  @Description 要注意next结点的处理
 */
public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenHead = head.next;
        ListNode currentOdd = head;
        ListNode currentEven = evenHead;

        while (currentEven != null) {
            currentOdd.next = currentEven.next;

            if (currentEven.next != null) {
                currentEven.next = currentEven.next.next;
            }

            currentEven = currentEven.next;

            if (currentOdd.next != null) {
                currentOdd = currentOdd.next;
            }
        }

        currentOdd.next = evenHead;

        return head;
    }
}
