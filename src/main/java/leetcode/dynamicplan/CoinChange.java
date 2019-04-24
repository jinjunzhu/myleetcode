package leetcode.dynamicplan;

/**
 * 找零问题
 * Created by jinjunzhu on 2019/4/5.
 * https://www.cnblogs.com/gaorong/p/6562021.html
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        //保存使用零钱数量
        int[][] dp = new int[coins.length][amount+1];
        for (int j = 1; j < amount + 1; j++){
            dp[0][j] = Integer.MAX_VALUE;
            if( j>=coins[0] && dp[0][j-coins[0]] !=Integer.MAX_VALUE ){
                dp[0][j] = dp[0][j-coins[0]]+1;
            }
        }
        for(int i=1; i<coins.length; i++){
            for(int j=1; j<=amount; j++){
                int left = Integer.MAX_VALUE;
                if( j>=coins[i] && dp[i][j-coins[i]] != Integer.MAX_VALUE ){
                    left=dp[i][j-coins[i]]+1;
                }
                dp[i][j] = Math.min( dp[i-1][j], left );
            }
        }

        return dp[coins.length-1][amount]==Integer.MAX_VALUE ? -1 : dp[coins.length-1][amount];
    }

    public static void main(String[] args){
        CoinChange coinChange = new CoinChange();
        int coins[] = new int[]{1,2,5};
        System.out.println(coinChange.coinChange(coins, 11));
    }
}
