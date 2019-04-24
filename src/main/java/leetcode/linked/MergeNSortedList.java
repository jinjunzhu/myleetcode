package leetcode.linked;

import scala.Int;

import java.util.List;

/**
 * 合并k个有序链表
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Created by jinjunzhu on 2019/3/29.
 */
public class MergeNSortedList {

    /**
     * 最优解
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    /**
     * 一般解
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (null == lists){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        ListNode head = null;
        ListNode last = null;
        Integer min = getMinHead(lists);
        while (min != null){
            if (head == null){
                head = new ListNode(min);
                min = getMinHead(lists);
                continue;
            }
            if (null == head.next){
                head.next = new ListNode(min);
                last = head.next;
            }else{
                last.next = new ListNode(min);
                last = last.next;
            }
            min = getMinHead(lists);
        }
        return head;
    }

    public static Integer getMinHead(ListNode[] lists){
        Integer start = null;
        Integer min = null;
        for(int i = 0; i < lists.length; i++){
            if (lists[i] == null){
                continue;
            }
            if (null == min){
                min = lists[i].val;
                start = i;
                continue;
            }
            if (lists[i].val < min){
                min = lists[i].val;
                start = i;
            }
        }
        if (null != start){
            lists[start] = lists[start].next;
        }
        return min;
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e) {
            return lists[s];
        }
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else{
            return null;
        }
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode3};
        ListNode mergedList = mergeKLists(listNodes);
        ListNode.printListNode(mergedList);
    }

}
