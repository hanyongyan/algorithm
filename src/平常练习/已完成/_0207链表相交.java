package 平常练习.已完成;

import java.sql.Blob;
import java.util.List;

public class _0207链表相交 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 获取 A 链表的长度
        ListNode tempA = headA;
        int aLen = 0;
        while (tempA != null) {
            tempA = tempA.next;
            aLen++;
        }

        // 获取 B 链表的长度
        ListNode tempB = headB;
        int bLen = 0;
        while (tempB != null) {
            tempB = tempB.next;
            bLen++;
        }

        // 下面是两种不同的情况
        if (aLen > bLen) {
            return withGetIntersectionNode(headA, headB, aLen - bLen);
        }
        return withGetIntersectionNode(headB, headA, bLen - aLen);

    }

    /**
     * @param headA 较长的链表
     * @param headB 较短的链表
     * @param n     二者的长度差
     * @return      找到了相交的节点
     */
    public static ListNode withGetIntersectionNode(ListNode headA, ListNode headB, int n) {
        // 对长链表的长度等于短链表
        for (int i = 0; i < n; i++) {
            headA = headA.next;
        }
        // 当两个链表不相等时继续往下查询
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
