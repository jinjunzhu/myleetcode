package leetcode.dynamicplan;

/**
 * Created by jinjunzhu on 2019/4/5.
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        // deal with the first row
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        // deal with the first col
        for(int i = 0; i < nums.length; i++){
            dp[i][0] = true;
        }

        // deal with the rest
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    boolean equal = false;
    private void hasPartition(int[] nums, int sum, int point, int currSum){
        if (currSum == sum){
            equal = true;
            return;
        }

        if (point == nums.length){
            return;
        }

        hasPartition(nums, sum, point + 1, currSum);
        if (currSum + nums[point] <= sum){
            hasPartition(nums, sum, point + 1, currSum + nums[point]);
        }
    }

    public static void main(String[] args){
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        int[] nums = {1,5,11,5};
        System.out.println(partitionEqualSubsetSum.canPartition(nums));
    }
}
