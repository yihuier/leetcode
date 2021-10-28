package from100;

import util.TreeNode;

public class Solution112 {

    /**
     * 递归实现，用roo.val累加的方式来判断
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        return recursionHashPathSum(root, 0, sum);
    }

    private boolean recursionHashPathSum(TreeNode root, int parentValue, int sum) {
        if (root == null) return false;

        int currentValue = root.val + parentValue;
        if (root.left == null && root.right == null) {
            return currentValue == sum;
        }

       return recursionHashPathSum(root.left, currentValue, sum) ||
               recursionHashPathSum(root.right, currentValue, sum);
    }

    /**
     * 递归实现，用sum-root.val的方式来判断
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) return root.val == sum;

        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
}
