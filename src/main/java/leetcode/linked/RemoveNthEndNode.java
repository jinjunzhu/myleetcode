package leetcode.linked;

import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Created by jinjunzhu on 2019/3/31.
 */
public class RemoveNthEndNode {

    /**
     * 一般解
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int i = 0;
        ListNode next = head;
        ListNode[] array = new ListNode[n + 1];
        while (true){
            if(i >= n + 1){
                for (int j=0; j< n; j++){
                    array[j] = array[j+1];
                }
                array[n-1] = head;
            }else{
                array[i++] = head;
            }
            if (head.next == null){
                break;
            }
        }
        if (i < n){
            return head;
        }

        array[0].next = array[2];
        return next;
    }

    /**
     * 最优解
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        if(head == null || head.next == null){
            return null;
        }

        int length = 0;
        ListNode temp = head;
        while(temp != null)
        {
            temp = temp.next;
            length++;
        }

        if(length - n == 0)
        {
            head = head.next;
            return head;
        }

        int counter = 1;
        temp = head;
        while(counter < length - n)
        {
            temp = temp.next;
            counter++;
        }

        temp.next = temp.next.next;

        return head;
    }
}
