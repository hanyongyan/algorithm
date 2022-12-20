package 平常练习.已完成;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import 平常练习.TreeNode;

public class _102二叉树的层序遍历 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 充当临时存储当前层的数据
        List<Integer> tempList = new ArrayList<>();
        // 存储当前层的节点
        Deque<TreeNode> nodes = new ArrayDeque<>();
        // 临时存放当前层的节点，把当前层的下一层添加到 nodes 中
        Deque<TreeNode> tempNodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            tempNodes = nodes;
            nodes = new ArrayDeque<>();
            while (!tempNodes.isEmpty()) {
                TreeNode tempNode = tempNodes.pop();
                tempList.add(tempNode.val);
                if (tempNode.left != null) {
                    nodes.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodes.add(tempNode.right);
                }
            }
            res.add(tempList);
            tempList = new ArrayList<>();
        }
        return res;
    }
}
