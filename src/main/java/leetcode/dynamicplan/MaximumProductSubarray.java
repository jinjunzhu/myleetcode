package leetcode.dynamicplan;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * Created by jinjunzhu on 2019/4/12.
 */
public class MaximumProductSubarray {

    /**最优解
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int ans = nums[0];
        for(int i = 0; i < nums.length; i ++ ){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i],nums[i]);
            min = Math.min(min * nums[i],nums[i]);
            ans = Math.max(max ,ans);
        }
        return ans;
    }

    /**东霆规划
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
            dpMin[i] = Math.min(nums[i], Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
        }
        int result = Integer.MIN_VALUE;
        for (int i : dpMax) {
            if (i > result) {
                result = i;
            }
        }
        return result;
    }

    public int maxProduct1(int[] nums) {
        int length = nums.length;
        if (null == nums || length == 0){
            return -1;
        }
        if (length == 1){
            return nums[0];
        }
        int max = nums[0];
        for (int i = 0; i < length; i++){
            int maxTemp = nums[i];
            for (int j = i+1; j < length; j++){
                if (nums[j] > max){
                    max = nums[j];
                }
                maxTemp *= nums[j];
                if (maxTemp > max){
                    max = maxTemp;
                }
            }
        }
        return max;
    }

}
