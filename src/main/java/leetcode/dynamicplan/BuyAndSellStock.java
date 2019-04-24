package leetcode.dynamicplan;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * Created by jinjunzhu on 2019/4/8.
 */
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0){
            return 0;
        }
        int max_diff = prices[1] - prices[0];
        int min_element = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - min_element > max_diff) {
                max_diff = prices[i] - min_element;
            }

            if (prices[i] < min_element) {
                min_element = prices[i];
            }
        }
        return max_diff;
    }
}
