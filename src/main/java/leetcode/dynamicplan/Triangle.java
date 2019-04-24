package leetcode.dynamicplan;

import java.util.List;

/**
 * 杨辉三角求最短路径
 * https://leetcode.com/problems/triangle/
 * Created by jinjunzhu on 2019/4/13.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.isEmpty()){
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = 0;i < triangle.get(triangle.size() - 1).size(); i ++){
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--){
            for (int j = 0; j <=i; j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return  dp[0][0];
    }
}
