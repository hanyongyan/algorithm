package 平常练习.已完成;

public class _24两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next= new ListNode(3);
        n.next.next.next = new ListNode(4);
        ListNode listNode = swapPairs(n);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /*
    给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     */
    /*
    由于只考虑本级递归，所以这个链表在我们眼里其实也就三个节点：head、head.next、已处理完的链表部分。
    而本级递归的任务也就是交换这3个节点中的前两个节点，就很easy了。
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = head.next;
        ListNode three = head.next.next;
        two.next = one;
        one.next = swapPairs(three);
        return two;
    }

}