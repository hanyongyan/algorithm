package 平常练习.已完成;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import 平常练习.TreeNode;

public class _144二叉树的前序遍历 {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        withPreorderTraversal(root,list);
        return list;
    }

    public static void withPreorderTraversal(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.val);
        withPreorderTraversal(root.left, list);
        withPreorderTraversal(root.right, list);
    }
}
