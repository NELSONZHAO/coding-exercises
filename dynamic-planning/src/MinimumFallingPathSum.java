/**
 * Created by Nelson on 2019/4/1.
 */

/**
 * 931. Minimum Falling Path Sum
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        // 思路：动态规划
        // 定义状态：memo[i][j]代表从A[i,j]点的 Minimum Falling Sum
        // 状态转移：memo[i][j] = Math.min{memo[i+1][j-1], memo[i+1][j], memo[i+1][j+1]} + A[i][j]

        int m = A.length;
        if( m == 0 )
            throw new IllegalArgumentException();

        int n = A[0].length;
        if( n == 0 )
            throw new IllegalArgumentException();

        assert m == n ;

        // 初始化
        int[][] memo = new int[2][n];
        // 初始化最后一行
        for( int j = 0; j < n; j++ ) {
            memo[(m-1)%2][j] = A[m-1][j];
        }

        // DP
        // 从倒数第二行开始
        for( int i = m - 2; i >= 0; i-- ) {
            for( int j = 0; j < n; j++ ) {
                memo[i%2][j] = Math.min(j-1 >= 0 ? memo[(i+1)%2][j-1] : Integer.MAX_VALUE
                                        , j+1 < n ? memo[(i+1)%2][j+1] : Integer.MAX_VALUE);
                memo[i%2][j] = Math.min(memo[i%2][j], memo[(i+1)%2][j]) + A[i][j];
            }
        }

        // 找到最小
        int ret = Integer.MAX_VALUE;
        for( int j = 0; j < n; j++ ) {
            ret = Math.min( ret, memo[0][j] );
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] A = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MinimumFallingPathSum solution = new MinimumFallingPathSum();
        System.out.println(solution.minFallingPathSum(A));
    }
}
