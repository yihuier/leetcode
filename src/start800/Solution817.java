package start800;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *  @author yihuier
 *  @Date 2020/9/9 19:29
 *  @Description 要注意条件的判断和划分，即什么情况下算是一个新的connected component
 */
public class Solution817 {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();

        for (int value : G) {
            set.add(value);
        }

        int count = 0;
        boolean flag = false;

        while (head != null) {
            if (set.isEmpty()) {
                break;
            }

            if (set.remove(head.val)) {
                if (!flag) {
                    count++;
                    flag = true;
                }
            } else {
                flag = false;
            }

            head = head.next;
        }

        return count;
    }
}
