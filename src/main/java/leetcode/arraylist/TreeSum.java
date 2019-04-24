package leetcode.arraylist;

import java.util.ArrayList;
import java.util.List;

/**求数组中3个数之和等于0的所有组合
 * https://leetcode.com/problems/3sum/submissions/
 * Created by jinjunzhu on 2019/3/29.
 */
public class TreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        //先排好序
        quick_sort_c(nums, 0 ,nums.length-1);

        List<List<Integer>> list=new ArrayList<>();

        int i = 0;
        //先固定第一个数，然后根据三个数的和大于还是小于0移动后两个数
        //下面出现的所有continue都是为了去重
        while(i<nums.length-2){
            if(nums[i]>0){
                return list;
            }

            if(i>0 && nums[i-1]==nums[i]){
                i++;
                continue;
            }

            //第二个数在头部，第三个数在尾部
            for(int j=i+1,k=nums.length-1;j<k;){
                if(j>i+1&&nums[j-1]==nums[j]){
                    j++;
                    continue;
                }
                if(k<nums.length-1&&nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                int temp=nums[i]+nums[j]+nums[k];
                if(temp>0){
                    k--;
                }else if(temp<0){
                    j++;
                }else{
                    List<Integer> list1=new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[k]);
                    list.add(list1);
                    j++;
                    k--;
                }
            }
            i++;
        }
        return list;
    }

    public static void quick_sort_c(int[] a, int m, int n){
        if (m >= n){
            return;
        }
        int p = partition(a, m, n);
        quick_sort_c(a, m, p-1);
        quick_sort_c(a, p+1, n);
    }

    public static int partition(int[] a, int m, int n){
        int pivot = a[n];
        int i = m;
        for (int j = i; j < n; j++){
            if(a[j] < pivot){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                ++i;
            }
        }
        int temp = a[i];
        a[i] = pivot;
        a[n] = temp;
        return i;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,0,0,0};
        List<List<Integer>> a = threeSum(nums);
        a.forEach(item -> {{
            item.forEach(child ->{{
                System.out.print(child + " ");
            }});
            System.out.println();
        }});
    }
}
