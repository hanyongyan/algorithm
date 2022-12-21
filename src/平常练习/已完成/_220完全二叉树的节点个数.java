package 平常练习.已完成;

import java.util.ArrayDeque;
import java.util.Deque;

import 平常练习.TreeNode;

public class _220完全二叉树的节点个数 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<TreeNode> tempNodes = new ArrayDeque<>();
        nodes.add(root);
        int res = 1;
        int size = nodes.size();
        while (size != 0) {
            tempNodes = nodes;
            nodes = new ArrayDeque<>();
            while (!tempNodes.isEmpty()) {
                TreeNode temp = tempNodes.pop();
                if (temp.left != null) {
                    res++;
                    nodes.add(temp.left);
                } else {
                    return res;
                }

                if(temp.right!=null){
                    res++;
                    nodes.add(temp.right);
                } else{
                    return res;
                }

            }
            size = nodes.size();
        }
        return -1;
    }
}
