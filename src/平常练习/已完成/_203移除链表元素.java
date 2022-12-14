package 平常练习.已完成;

import java.util.List;

public class _203移除链表元素 {
  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    n1.next = new ListNode(2);
    n1.next.next = new ListNode(6);
    n1.next.next.next = new ListNode(6);
    n1.next.next.next.next = new ListNode(4);
    n1.next.next.next.next.next = new ListNode(6);
    ListNode res = removeElements(n1, 6);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  public static ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    head.next = removeElements(head.next, val);
    // 如果当前值是目标值，就返回下一个节点，如果不是就返回当前节点
    return head.val == val ? head.next : head;
  }

  public static ListNode process2(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode cur = head;
    // 始终保持 pre 是 cur 的上一个节点
    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next;
      } else {
        pre = cur;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
