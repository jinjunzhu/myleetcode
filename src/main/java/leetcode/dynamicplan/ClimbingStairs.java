package leetcode.dynamicplan;

/**
 * 爬楼梯问题  一步两步 最多几种方式
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 * Created by jinjunzhu on 2019/4/3.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {

        if(n < 2){
            return 1;
        }

        int[] p = new int[n+1];
        p[0] = p[1] = 1;
        for (int i = 2; i <= n; i++){
            p[i] = p[i-1] + p[i-2];
        }
        return p[n];

    }
}
