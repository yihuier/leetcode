package from700;

import util.ListNode;

/**
 *  @author yihuier
 *  @Date 2020/10/27 17:11
 *  @Description 先计算出链表的长度，然后求出每个小链表的最小个数，以及最前面的多少个小链表需要多一个结点
 *  注意空节点的处理
 */
public class Solution725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int nodeCount = 0;
        ListNode current = root;

        // 计算链表的结点个数
        while (current != null) {
            nodeCount++;
            current = current.next;
        }

        int minSize = nodeCount / k;
        int num = nodeCount % k;

        ListNode[] result = new ListNode[k];
        current = root;
        for (int i = 0; i < k; i++) {
            int count = 0;
            ListNode listNode = new ListNode();
            ListNode tmp = listNode;

            while (count < minSize) {
                if (current == null) {
                    tmp.next = null;
                    count++;
                    continue;
                }

                tmp.next = new ListNode(current.val);
                tmp = tmp.next;
                current = current.next;
                count++;
            }

            if (i < num && current != null) {
                tmp.next = new ListNode(current.val);
                tmp = tmp.next;
                tmp.next = null;
                current = current.next;
            }

            result[i] = listNode.next;
        }

        return result;
    }
}
