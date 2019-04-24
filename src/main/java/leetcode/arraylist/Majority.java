package leetcode.arraylist;

/**
 * 求众数
 * https://leetcode.com/problems/majority-element/
 * Created by jinjunzhu on 2019/3/29.
 */
public class Majority {
    /**
     * 最优解
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return major;


    }

    public static int majorityElement1(int[] nums) {

        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
