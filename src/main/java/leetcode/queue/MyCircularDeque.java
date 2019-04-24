package leetcode.queue;

/**
 * 实现循环队列
 * https://leetcode.com/problems/design-circular-deque/
 * Created by jinjunzhu on 2019/4/2.
 */
public class MyCircularDeque {
    /** Initialize your data structure here. Set the size of the deque to be k. */
    private int n;
    private int head;
    private int tail;
    private int[] circleQueue;
    public MyCircularDeque(int k) {
        this.n = k + 1;
        this.tail = 0;
        this.head = 0;
        circleQueue = new int[k + 1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        head = head -1 < 0 ? head + n - 1: head - 1;
        circleQueue[head] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        circleQueue[tail] = value;
        tail = tail + 1 == n ? 0 : tail + 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return  false;
        }
        head = head + 1 == n ? 0 : head + 1;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return  false;
        }
        tail = tail -1 < 0 ? tail + n - 1: tail - 1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return circleQueue[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (head == tail){
            return -1;
        }
        return tail-1 < 0 ? circleQueue[tail -1 + n] : circleQueue[tail-1];

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (tail + 1) % n == head;
    }

    public static void main(String[] args){
        MyCircularDeque circularDeque = new MyCircularDeque(4);
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertFront(6));
        System.out.println(circularDeque.insertLast(5));
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(6));
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
