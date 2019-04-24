package leetcode.dynamicplan;

/**
 * 最小步数问题
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * Created by jinjunzhu on 2019/4/3.
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[10000];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[cost.length];
    }
}
