package start400;

import util.TreeNode;

public class Solution404 {

    /**
     * 递归，
     * 如果左节点是叶子节点，那么sum = 左节点的值 + 右子树中左叶子的和
     * 如果左子树不是叶子节点，那么sum = 左子树中左叶子的和 + 右子树中左叶子的和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        if (isLeave(root.left)){
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeave(TreeNode node) {
        if (node == null) return false;

        return node.left == null && node.right == null;
    }
}
