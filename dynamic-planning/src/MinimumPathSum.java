/**
 * Created by Nelson on 2019/3/17.
 */

/**
 * 64. Minimum Path
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        // 思路：动态规划
        // 定义状态：memo[i][j]代表从起始点到(i, j)的最小路径和
        // 状态转移：memo[i][j] = min( memo[i-1][j], memo[i][j-1] );

        //
        int m = grid.length;
        if( m <= 0 )
            throw new IllegalArgumentException();

        int n = grid[0].length;
        if( n <= 0 )
            throw new IllegalArgumentException();

        // 初始化矩阵
        int[][] memo = new int[m][n];

        // 初始化第一行
        memo[0][0] = grid[0][0];
        for( int j = 1; j < n; j++ )
            memo[0][j] = memo[0][j-1] + grid[0][j];

        // 初始化第一列
        for( int i = 1; i < m; i++ )
            memo[i][0] = memo[i-1][0] + grid[i][0];

        // DP
        for( int i = 1; i < m; i++ ) {
            for( int j = 1; j < n; j++ ) {
                memo[i][j] = Math.min( memo[i-1][j], memo[i][j-1] ) + grid[i][j];
            }
        }

        return memo[m-1][n-1];
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        MinimumPathSum solution = new MinimumPathSum();
        System.out.println(solution.minPathSum(grid));
    }
}
