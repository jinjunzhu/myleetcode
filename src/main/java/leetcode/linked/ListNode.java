package leetcode.linked;

/**
 * Created by jinjunzhu on 2019/3/31.
 */
public class ListNode {

    //Definition for singly-linked list.
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public static void printListNode(ListNode listNode){
        System.out.println(listNode.val);
        if (listNode.next != null){
            printListNode(listNode.next);
        }
    }
}
