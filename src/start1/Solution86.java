package start1;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/11/2 17:29
 *  @Description 链表分区
 */
public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        ListNode partitionOneTail = new ListNode();
        partitionOneTail.next = head;
        head = partitionOneTail;
        ListNode current = head;

        // 注意要先处理最开始几个小于x的
        while (current.next != null && current.next.val < x) {
            partitionOneTail = current.next;
            current = current.next;
        }

        while (current.next != null) {
            if (current.next.val < x) {
                ListNode tmp = current.next;
                current.next = tmp.next;
                tmp.next = partitionOneTail.next;
                partitionOneTail.next = tmp;
                partitionOneTail = partitionOneTail.next;
            } else {
                current = current.next;
            }
        }

        return head.next;
    }
}
