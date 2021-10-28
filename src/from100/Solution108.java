package from100;

import util.TreeNode;

public class Solution108 {

    /**
     * 由于给定数组是递增的数组，所以可以借助二分查找的思想直接构建一个平衡二叉树
     * 每次找出中间值作为当前树的root结点，运用递归很容易就可以实现
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return recursiveBuildBST(nums, 0, nums.length - 1);
    }

    private TreeNode recursiveBuildBST(int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = low + ((high - low) >> 1);
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = recursiveBuildBST(nums, low, mid - 1);
        treeNode.right = recursiveBuildBST(nums, mid + 1, high);

        return treeNode;
    }
}
