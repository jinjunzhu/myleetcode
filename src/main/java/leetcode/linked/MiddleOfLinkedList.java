package leetcode.linked;

/**
 * 求链表中间的数，偶数取后者
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Created by jinjunzhu on 2019/3/31.
 */
public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {

        int i = 0;
        ListNode begin = head;
        while(head != null){
            i ++;
            head = head.next;
        }
        int j = (i >> 1) + 1;
        int k = 0;
        while(begin != null){
            k ++;
            if (k == j){
                return begin;
            }
            begin = begin.next;
        }
        return null;
    }

    public static void main(String[] args){
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(3);
        listNode2.next.next.next = new ListNode(4);
        listNode2.next.next.next.next = new ListNode(5);
        ListNode.printListNode(middleNode(listNode2));
    }
}
