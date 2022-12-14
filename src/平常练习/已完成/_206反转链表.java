package 平常练习.已完成;

import java.util.ArrayList;
import java.util.List;

public class _206反转链表 {
    public static void main(String[] args) {

    }

    // 最笨蛋的方法，浪费空间
    public static ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(-1);
        ListNode tempNode = res;
        int len = list.size();
        for (int i = len - 1; i >= 0; i--) {
            tempNode.next = new ListNode(list.get(i));
            tempNode = tempNode.next;
        }
        return res.next;
    }

    public static ListNode process2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode process3(ListNode head) {
        return withProcess3(null, head);
    }

    private ListNode withProcess3(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return withProcess3(cur, temp);
    }
}