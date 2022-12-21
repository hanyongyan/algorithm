package 平常练习.已完成;

import 平常练习.TreeNode;

public class _404左叶子之和 {
    public static void main(String[] args) {

    }

    public static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        search(root);
        return sum;
    }

    public static void search(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        search(root.left);
        search(root.right);
    }
}
