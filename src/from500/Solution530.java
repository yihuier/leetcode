package from500;

import util.TreeNode;

/**
 *  @author yihuier
 *  @Date 2020/4/16 20:14
 *  @Description 只会这种效率低的做法，另一种暂时不能理解
 */
public class Solution530 {

    public int getMinimumDifference(TreeNode root) {
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;

        findMinDifOfRoot(root, min);

        return min[0];
    }

    private void findMinDifOfRoot(TreeNode root, int[] min) {
        if (root == null) {
            return;
        }

        getMinDif(root, root.left, min);
        getMinDif(root, root.right, min);

        findMinDifOfRoot(root.left, min);
        findMinDifOfRoot(root.right, min);
    }

    private void getMinDif(TreeNode root, TreeNode current, int[] min) {
        if (current == null) {
            return;
        }

        min[0] = Math.min(min[0], Math.abs(root.val - current.val));

        getMinDif(root, current.left, min);
        getMinDif(root, current.right, min);
    }
}
