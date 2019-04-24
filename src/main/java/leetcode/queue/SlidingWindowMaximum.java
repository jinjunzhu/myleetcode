package leetcode.queue;

/**
 * 窗口滑动问题
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Created by jinjunzhu on 2019/4/3.
 */
public class SlidingWindowMaximum {
    /**
     * 最优解
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k<=0){
            return new int[0];
        }
        int[] dequeue = new int[k];
        int[] max = new int[nums.length-k+1];
        int pos = 0, len = 0;
        int j=0;
        for(int i=0; i<nums.length; i++) {
            if (len > 0 && i-dequeue[pos]>=k) {
                pos = (pos+1) % k;
                len --;
            }
            if (len == 0){
                dequeue[(pos+(len++))%k] = i;
            }else {
                while (len > 0 && nums[dequeue[(pos+len-1)%k]] <= nums[i]){
                    len --;
                }
                dequeue[(pos+(len++))%k] = i;
            }
            if (i>=k-1){
                max[j++] = nums[dequeue[pos]];
            }
        }
        return max;
    }
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int length = nums.length;
        if (null == nums || length == 0){
            return new int[0];
        }

        int queue[] = new int[k];
        queue[0] = 0;
        int maxp = 0;
        for (int i = 1; i < k; i++){
            if (nums[i] > nums[queue[0]]){
                queue[0] = i;
                queue[i] = 0;
            }else{
                queue[i] = i;
            }
        }
        int max[] = new int[length - k + 1];
        max[maxp ++] = nums[queue[0]];
        for (int i = k; i < length; ++i){
            max[maxp ++] = enqueue(queue, nums, i, k);
        }
        return max;
    }

    private int enqueue(int[] queue, int[] nums, int m, int k){
        if (queue[0] == m - k){
            queue[0] = m;
            for (int i = 1; i < queue.length; i++){
                if (nums[queue[i]] > nums[queue[0]]){
                    int temp = queue[i];
                    queue[i] = queue[0];
                    queue[0] = temp;
                }
            }
        }else{
            int p = -1;
            for (int i = 0; i < queue.length; i++){
                if (queue[i] == m - k){
                    queue[i] = m;
                    p = i;
                    break;
                }
            }
            if (p > 0 && nums[queue[0]] < nums[queue[p]]){
                int temp = queue[p];
                queue[p] = queue[0];
                queue[0] = temp;
            }
        }
        return nums[queue[0]];
    }

    public static void main(String[] args){
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
        int[] maxnum = slidingWindowMaximum.maxSlidingWindow1(nums, 7);
        for (int i = 0; i < maxnum.length; i++){
            System.out.println(maxnum[i]);
        }
    }
}
