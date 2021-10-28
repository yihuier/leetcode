package from1000;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author yihuier
 *  @Date 2020/9/9 19:10
 *  @Description 除了两次遍历链表还有什么做法吗
 */
public class Solution1019 {

    /**
     * 两次遍历链表有点蠢
     */
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> resultList = new ArrayList<>();

        while (head != null) {
            ListNode current = head.next;
            int larger = 0;

            while (current != null) {
                if (head.val < current.val) {
                    larger = current.val;
                    break;
                }

                current = current.next;
            }

            resultList.add(larger);
            head = head.next;
        }

        int[] results = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            results[i] = resultList.get(i);
        }

        return results;
    }
}
