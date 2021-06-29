package start100;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
//        recursiveTraversal(resultList, root);
        iterativeTraversal(resultList, root);
        return resultList;
    }

    private void recursiveTraversal(List<Integer> resultList, TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveTraversal(resultList, root.left);
        resultList.add(root.val);
        recursiveTraversal(resultList, root.right);
    }

    private void iterativeTraversal(List<Integer> resultList, TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !nodeStack.isEmpty()) {
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!nodeStack.isEmpty()) {
                currentNode = nodeStack.pop();
                resultList.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
    }
}
