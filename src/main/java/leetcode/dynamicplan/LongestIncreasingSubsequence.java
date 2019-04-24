package leetcode.dynamicplan;

/**
 * 最长有序子序列
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * Created by jinjunzhu on 2019/4/12.
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max_length = 1;
        //i之前的最大有序序列
        int[] max = new int[nums.length];
        max[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    max[i] = 1;
                    continue;
                }
                if (max[i] < max[j] + 1) {
                    max[i] = max[j] + 1;
                }
            }
            if (max_length < max[i]) {
                max_length = max[i];
            }
        }
        return max_length;
    }

    public static void main(String[] args){
        int nums[] = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }
}
