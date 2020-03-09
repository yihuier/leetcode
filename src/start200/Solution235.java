package start200;

import util.TreeNode;

public class Solution235 {

    /**
     * 根据二叉查找树的性质
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        int parentValue = root.val;
        int pValue = p.val;
        int qValue = q.val;

        if (pValue > parentValue && qValue > parentValue) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (pValue < parentValue && qValue < parentValue) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}
