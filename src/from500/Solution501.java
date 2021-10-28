package from500;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution501 {

    /**
     *  @author: yihuier
     *  @Date: 2020/4/9 22:36
     *  @Description: 先递归计算出所有节点值出现的个数并且得出出现最多次的值的个数max[0]
     *  然后再移除出现次数不是max[0]的节点值。这里使用一个只有一个元素的数组来实现引用传递的效果
     */
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> nodeCountMap = new HashMap<>();
        int[] max = new int[1];

        recursion(nodeCountMap, root, max);
        // 移除不满足条件的元素
        nodeCountMap.entrySet().removeIf(entry -> entry.getValue() < max[0]);

        int[] result = new int[nodeCountMap.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry : nodeCountMap.entrySet()) {
            if (entry.getValue() == max[0]) {
                result[k++] = entry.getKey();
            }
        }

        return result;
    }

    private void recursion(Map<Integer, Integer> map, TreeNode root, int[] max) {
        if (root == null) {
            return;
        }

        int count = map.getOrDefault(root.val, 0) + 1;
        if (count > max[0]) {
            max[0] = count;
        }
        map.put(root.val, count);

        recursion(map, root.left, max);
        recursion(map, root.right, max);
    }
}
