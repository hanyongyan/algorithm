package 平常练习.已完成;

import java.util.List;

import 平常练习.ListNode;

public class _82删除排序链表中的重复元素2 {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        // 判断执行条件
        while (cur.next != null && cur.next.next != null) {
            // 如果当前节点的下一个节点的值 等于 下下一个节点的值 此时找到了重复节点
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                // 判断后续还有没有与此值重复的节点
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
