package start100;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution111 {

    /**
     * 使用层次遍历，遇到的第一个叶子节点则返回当前的depth
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        int currentDepth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            currentDepth++;
            // 记录该层的节点数
            int levelNodeNum = queue.size();

            // 该循环遍历一层节点
            while (levelNodeNum > 0) {
                TreeNode node = queue.poll();

                if (node != null) {
                    if (node.left == null && node.right == null) return currentDepth;
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                levelNodeNum--;
            }
        }

        return currentDepth;
    }

    /**
     * 递归实现
     */
    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        // 左子节点为空，那么叶子节点只能在右子树，所以求右子树的minDepth
        if (root.left == null) return minDepth(root.right) + 1;
        // 右子节点为空，那么叶子节点只能在左子树，所以求左子树的minDepth
        if (root.right == null) return minDepth(root.left) + 1;
        // 左右节点都不为空，那么取两者的minDepth的较小值
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
