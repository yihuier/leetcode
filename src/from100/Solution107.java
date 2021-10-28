package from100;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution107 {

    /**
     * 非递归实现，采用一层一层处理的做法
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> allElem = new ArrayList<>();
        Queue<TreeNode> curLevelNodes = new ArrayDeque<>();

        if (root == null) return allElem;

        curLevelNodes.add(root);
        while (!curLevelNodes.isEmpty()) {
            List<Integer> levelElem = new ArrayList<>();
            // 用levelNodeNum来记录每一层的节点数
            int levelNodeNum = curLevelNodes.size();

            // 将同一层的所有节点都取出
            while (levelNodeNum > 0) {
                TreeNode node = curLevelNodes.poll();
                levelNodeNum--;

                if (node != null) {
                    levelElem.add(node.val);
                    if (node.left != null) curLevelNodes.offer(node.left);
                    if (node.right != null) curLevelNodes.offer(node.right);
                }
            }
            allElem.add(0, levelElem);
        }

        return allElem;
    }

    /**
     * 递归实现
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> allElem = new ArrayList<>();

        if (root == null) return allElem;

        // 默认根节点为第一层
        recursiveLevelOrder(root, 1, allElem);

        return allElem;
    }

    private void recursiveLevelOrder(TreeNode root, int level, List<List<Integer>> allElem) {
        if (root == null) return;

        // 如果allElem的长度小于层数，说明当前节点是某一层的最左节点
        // 所以新增存放该层的数组，并放在allElem的最前面
        if (allElem.size() < level) {
            List<Integer> levelElem = new ArrayList<>();
            allElem.add(0, levelElem);
        }
        // 把该节点放在对应的位置，层数越高位置越靠后
        allElem.get(allElem.size() - level).add(root.val);

        // 递归子节点
        recursiveLevelOrder(root.left, level + 1, allElem);
        recursiveLevelOrder(root.right, level + 1, allElem);
    }
}
