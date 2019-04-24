package leetcode.arraylist;

/**
 * Created by jinjunzhu on 2019/4/11.
 */
public class MergeTwoSortedArray {

    /**
     * 最优解
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int pos = m + n - 1;
        while (i1 >= 0 && i2 >= 0) {
            nums1[pos--] = nums1[i1] >= nums2[i2] ? nums1[i1--] : nums2[i2--];
        }
        while(i1 >= 0) {
            nums1[pos--] = nums1[i1--];
        }
        while(i2 >= 0) {
            nums1[pos--] = nums2[i2--];
        }
    }

    /**
     * 一般解
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            for (int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0){
            return;
        }
        if (nums2[0] > nums1[m-1]){
            for (int i = 0; i < n; i++){
                nums1[m + i] = nums2[i];
            }
        }
        //nums1中查找开始指针
        int start = 0;
        //nums2中结束指针
        int end = 0;
        int count = m;
        for (int i = 0;i < n;i++){
            for (int j = start; j < count; j++){
                if (nums2[i] <= nums1[j]){
                    start ++;
                    for (int k = count; k > j; k--){
                        nums1[k] = nums1[k-1];
                    }
                    ++count;
                    nums1[j] = nums2[i];
                    end ++ ;
                    break;
                }
            }
        }

        if (end < n){
            for (int i = end; i < n; i++){
                nums1[count++] = nums2[i];
            }
        }
    }

    public static void main(String[] args){
        MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();
        int[] num1={4,0,0,0,0,0};
        int[] num2={1,2,3,5,6};
        mergeTwoSortedArray.merge(num1,1,num2,5);
        System.out.println(num1);

    }
}
