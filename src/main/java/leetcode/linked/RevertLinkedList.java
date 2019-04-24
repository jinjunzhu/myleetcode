package leetcode.linked;

import java.util.List;

/**
 * 反转数组
 * https://leetcode.com/problems/reverse-linked-list/
 * Created by jinjunzhu on 2019/3/31.
 */
public class RevertLinkedList {

    public static ListNode reverseList(ListNode head) {
        if (null == head){
            return null;
        }
        ListNode pre = head;
        while(head.next != null){
            ListNode next = head.next;
            if (next.next != null){
                head.next = next.next;
                next.next = pre;
                pre = next;
            }else{
                next.next = pre;
                head.next = null;
                pre = next;
                break;
            }
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode.printListNode(reverseList(listNode2));
    }
}
