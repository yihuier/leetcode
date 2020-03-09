package start200;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    /**
     * 相当于树的遍历
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        treePaths(paths, "", root);

        return paths;
    }

    private void treePaths(List<String> paths, String currentPath, TreeNode node) {
        if (node == null) return;

        currentPath += Integer.toString(node.val);

        if (node.left == null && node.right == null) {
            paths.add(currentPath);
            return;
        }

        currentPath += "->";
        treePaths(paths, currentPath, node.left);
        treePaths(paths, currentPath, node.right);
    }
}
