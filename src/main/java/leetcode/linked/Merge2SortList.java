package leetcode.linked;

/**
 * 合并2个有序链表
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * Created by jinjunzhu on 2019/3/31.
 */
public class Merge2SortList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        merge(l1, l2);
        return head;
    }

    static ListNode pre = null;
    static ListNode head = null;
    public static void merge(ListNode l1, ListNode l2){
        if (l1.val >= l2.val){
            ListNode next = l2.next;
            l2.next = l1;
            if (head == null){
                head = l2;
            }else{
                pre.next = l2;
            }
            pre = l2;
            if (null == next){
                return;
            }
            mergeTwoLists(l1, next);
        }else{
            if (head == null){
                head = l1;
            }
            pre = l1;
            if (l1.next == null){
                l1.next = l2;
                return;
            }
            l1 = l1.next;
            mergeTwoLists(l1, l2);
        }
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode.printListNode(mergeTwoLists(listNode1, listNode2));
    }
}
