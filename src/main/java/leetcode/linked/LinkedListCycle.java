package leetcode.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/nily/p/4856893.html
 * 查询链表上是凑存在环
 * https://leetcode.com/problems/linked-list-cycle/
 * Created by jinjunzhu on 2019/3/29.
 */
public class LinkedListCycle {

    /**
     * 最优解
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode.next != null && slowNode.next != null){
            fastNode = fastNode.next;
            if (fastNode.next == null){
                return false;
            }
            fastNode = fastNode.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        while (head.next != null){
            if (listNodes.contains(head.next)){
                return true;
            }
            listNodes.add(head.next);
            head = head.next;
        }
        return false;
    }
}
