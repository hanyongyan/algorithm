package 平常练习.已完成;

import java.util.LinkedList;
import java.util.Queue;

import 平常练习.TreeNode;

public class _513找树左下角的值 {
    public static void main(String[] args) {

    }

    
    // 使用了层序遍历，遍历到最后一层的第一个即是 最底层 最左边的节点的值
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    // 以下是第二中方法
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue2(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) return;
        // 因为是使用的前序遍历，所以当第一到达一个新的深度时，一定当前层的最左侧的节点
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }
}
