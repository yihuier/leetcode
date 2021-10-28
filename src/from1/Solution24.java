package from1;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/10/28 15:49
 *  @Description 交换节点，注意链表的指向
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        // 添加这个空值节点作为头部节点便于统一处理，或者叫做哨兵节点？
        ListNode current = new ListNode();
        current.next = head;
        head = current;
        ListNode prev = head;
        current = head.next;

        // 需要注意的是交换节点的时候不仅要考虑后续节点，也要考虑前面已经交换过的节点
        while (current != null && current.next != null) {
            ListNode tmp = current.next;
            current.next = tmp.next;
            tmp.next = current;
            prev.next = tmp;

            prev = current;
            current = current.next;
        }

        return head.next;
    }
}
