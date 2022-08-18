package 平常练习.已完成;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 平常练习.TreeNode;

public class _107二叉树的层序遍历2 {
    public static void main(String[] args) {

    }

    /**
     * 完成二叉树的层序遍历
     * @param root  二叉树的根节点
     * @return      二叉树的层序遍历结果
     */

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> rowList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rowList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(0, rowList);
        }
        return list;
    }
}
