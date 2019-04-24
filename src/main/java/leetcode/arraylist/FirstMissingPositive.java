package leetcode.arraylist;

/**查找第一个缺失的正整数
 * https://leetcode.com/problems/first-missing-positive/
 * Created by jinjunzhu on 2019/3/29.
 */
public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int[] temp = new int[nums.length + 2];
        for (int i = 0; i < temp.length; i++){
            temp[i] = -1;
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                continue;
            }
            if (nums[i] <= nums.length){
                temp[nums[i]] = 1;
            }
        }

        for (int i = 1; i < temp.length; i++){
            if(temp[i] == -1){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1};
        System.out.println(firstMissingPositive(nums));
    }


}
