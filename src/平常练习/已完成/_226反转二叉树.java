package 平常练习.已完成;

import 平常练习.TreeNode;

public class _226反转二叉树 {
    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        return withInvertTree(root);
    }

    public static TreeNode withInvertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tempNode = new TreeNode();
        tempNode = root.left;
        // root.left = root.right;
        // root.right = tempNode;
        root.left = withInvertTree(root.right);
        root.right = withInvertTree(tempNode);
        return root;
    }
}
