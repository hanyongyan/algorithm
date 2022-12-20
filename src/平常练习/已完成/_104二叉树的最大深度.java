package 平常练习.已完成;

import 平常练习.TreeNode;

public class _104二叉树的最大深度 {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        // 如果当前节点为 null 就返回 0 层
        if (root == null) {
            return 0;
        }
        // 返回左右节点的最大深度，因为自身也是一层深度所以要加一
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
