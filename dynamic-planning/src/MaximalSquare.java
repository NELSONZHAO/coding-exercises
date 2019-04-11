/**
 * Created by Nelson on 2019/4/11.
 */

/**
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        // 思路：动态规划
        // 状态：f(i, j)代表以matrix[i][j]为right-down corner的最大square的边长
        // 转移：
        // if matrix[i][j] = 0, f(i, j) = 0
        // else matrix[i][j] = 1, f(i, j) = min{f(i-1, j-1), f(i-1, j), f(i, j-1)} + 1

        int m = matrix.length;
        if( m == 0 )
            return 0;

        int n = matrix[0].length;
        if( n == 0 )
            return 0;

        // 初始化
        int[][] dp = new int[m+1][n+1];
        int ret = 0;

        // 迭代
        for( int i = 1; i <= m; i++ ) {
            for( int j = 1; j <= n; j++ ) {
                if( matrix[i-1][j-1] == '1' ) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }

                ret = Math.max(ret, dp[i][j]);
            }
        }

        return ret * ret;

    }

    public static void main(String[] args) {
        // 测试用例
        char[][] matrix = new char[][]{
                {'1', '0', '0', '0'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };

        MaximalSquare solution = new MaximalSquare();
        System.out.println(solution.maximalSquare(matrix));
    }
}
