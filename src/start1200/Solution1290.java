package start1200;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/9/9 19:00
 *  @Description 简单位运算即可解决
 */
public class Solution1290 {

    public int getDecimalValue(ListNode head) {
        int value = 0;

        while (head != null) {
            value <<= 1;
            value += head.val;

            head = head.next;
        }

        return value;
    }
}
