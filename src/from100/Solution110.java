package from100;

import util.TreeNode;

public class Solution110 {

    /**
     * 判断左右子树是否平衡、以及左右子树的高度差不能大于1
     */
    public boolean isBalanced2(TreeNode root) {

        return isBalance(root);
    }

    private boolean isBalance(TreeNode root) {
        // null 认为是平衡的
       if (root == null) return true;
       // 叶子节点也是平衡的
       if (root.left == null && root.right == null) return true;
       // 左子树为null，右子树的高度不能超过1
        if (root.left == null) return root.right.left == null && root.right.right == null;
        // 右子树为null，左子树的高度不能超过1
        if (root.right == null) return root.left.left == null && root.left.right == null;
        // 左右子树都不为null，左右子树都是平衡的，并且左右子树高度不超过1
        return isBalance(root.left) && isBalance(root.right)
                && (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1);
    }

    private int treeDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return treeDepth(root.right) + 1;
        if (root.right == null) return treeDepth(root.left) + 1;

        return Math.max(treeDepth(root.left) + 1, treeDepth(root.right) + 1);
    }

    /**
     * 也是判断左右子树高度差和左右子树分别是否平衡，但是相比上面的做法更加简单高效
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1)
                && isBalanced(root.left) && isBalanced(root.right);
    }
}
