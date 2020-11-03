package start1100;

import util.ListNode;


/**
 *  @author yihuier
 *  @Date 2020/11/3 19:43
 *  @Description
 */
public class Solution1171 {

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }

        int sum = 0;
        ListNode current = head;

        // 如果current是连续序列中的一个，那么只有可能是和之后的某一些（零个或者多个）节点相加为0
        while (current != null) {
            sum += current.val;
            current = current.next;

            if (sum == 0) {
                return removeZeroSumSublists(current);
            }
        }

        // 执行到这里说明current不是连续序列中的一个，所以与后面剩余节点连接上即为结果
        return new ListNode(head.val, removeZeroSumSublists(head.next));
    }
}
