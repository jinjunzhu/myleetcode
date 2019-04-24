package leetcode.dynamicplan;

/**
 * 最短路径问题
 * https://leetcode.com/problems/minimum-path-sum/
 * Created by jinjunzhu on 2019/4/5.
 */
public class MinimuPathSum {

    /**
     * 最优解
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[0].length; ++j){
                int v = Integer.MAX_VALUE;
                if (i > 0){
                    v = grid[i - 1][j];
                }
                if (j > 0){
                    v = Math.min(grid[i][j - 1], v);
                }
                if (v != Integer.MAX_VALUE){
                    grid[i][j] += v;
                }
            }
        }
        return grid[grid.length -1][grid[0].length - 1];
    }




    public int minPathSum1(int[][] grid) {
        return min(grid, grid.length-1, grid[0].length - 1);
    }

    private int min(int[][] grid, int i, int j){
        if (i == 0 && j == 0){
            return grid[i][j];
        }
        if (i == 0 ){
            return min(grid, i, j-1) + grid[i][j];
        }
        if (j == 0){
            return min(grid, i-1, j) + grid[i][j];
        }
        return Math.min(min(grid, i, j-1),min(grid, i-1, j)) + grid[i][j];
    }

    public static void main(String[] args){
        MinimuPathSum minimuPathSum = new MinimuPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minimuPathSum.minPathSum(grid));
    }
}
