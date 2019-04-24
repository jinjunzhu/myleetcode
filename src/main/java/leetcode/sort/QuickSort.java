package leetcode.sort;

/**
 * Created by jinjunzhu on 2019/3/29.
 */
public class QuickSort {

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
        int[] a = new int[]{3,4,34,35,31,6,8,2,1};
        quick_sort_c(a, 0 ,a.length-1);
        for (int i = 0; i< a.length; i++){
            System.out.println(a[i]);
        }
    }
}
