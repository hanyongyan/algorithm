package 平常练习;

import java.util.ArrayList;
import java.util.List;

public class _95不同的二叉搜索数2 {
    public static void main(String[] args) {

    }

    /*
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     */

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return process(1, n);
    }

    public static List<TreeNode> process(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        // 找到 i 为根节点 左右上限是 start 和 end 时的所有二叉树可能
        for (int i = start; i <= end; i++) {
            // 获取左边的值组成二叉树的所有可能
            List<TreeNode> left = process(start, i - 1);
            // 获取右边的值组成二叉树的所有可能
            List<TreeNode> right = process(i + 1, end);
            for (TreeNode treeNode : right) {
                for (TreeNode treeNode2 : left) {
                    TreeNode node = new TreeNode(i);
                    node.right = treeNode;
                    node.left = treeNode2;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
