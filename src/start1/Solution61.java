package start1;

import util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author yihuier
 *  @Date 2020/11/6 16:29
 *  @Description
 */
public class Solution61 {

    /**
     * 计算总长度，并把结点保存到map中，然后取出想要的结点进行操作
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int count = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;

        while (cur != null) {
            count++;
            map.put(count, cur);
            cur = cur.next;
        }

        if (k >= count && k % count == 0) {
            return head;
        }

        k = k > count ? k % count : k;

        ListNode last = map.get(count - k);
        last.next = null;
        ListNode leftLast = map.get(count);
        leftLast.next = head;

        return map.get(count - k + 1);
    }

    /**
     * 找出总长度，然后再重新遍历一遍找出新链表的尾结点的头结点
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int size = 1;
        ListNode cur = head;

        while (cur.next != null) {
            size++;
            cur = cur.next;
        }

        if (k >= size && k % size == 0) {
            return head;
        }

        ListNode tail = cur;
        k = k > size ? k % size : k;
        int count = 1;
        cur = head;

        while (count < (size - k)) {
            cur = cur.next;
            count++;
        }

        tail.next = head;
        head = cur.next;
        cur.next = null;


        return head;
    }
}
