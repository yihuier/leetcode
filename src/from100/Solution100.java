package from100;

import util.TreeNode;

public class Solution100 {

     public boolean isSameTree(TreeNode p, TreeNode q) {
        // 比较当前树的父结点
        // 1、都为null或者两者为同一个结点
        // 2、都不为null
        // 3、一个为null一个不为null
        if (p == q) return true;

        if (p != null && q != null) {
            // 父结点都不为null，比较父结点的值
            // 1、不相等，返回false
            // 2、相等，递归比较子结点
            if (p.val != q.val) return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}
