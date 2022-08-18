package 平常练习.已完成;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import 平常练习.TreeNode;

public class _103二叉树的锯齿形层序遍历{
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 0;
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
            index++;
            if(index % 2 == 1) {
                list.add(rowList);
            } else {
                Collections.reverse(rowList);
                list.add(rowList);
            }
            
        }
        return list;
    }
}