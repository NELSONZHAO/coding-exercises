/**
 * Created by Nelson on 2019/3/10.
 */

/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 * 给定m x n的矩阵格子，其中0代表通畅， 1代表障碍物，问agent从左上角到右下角的路径数有多少条。其中agent每步只能右移或者下移
 */

public class UniquePathsII {

    public int uniquePathsII(int[][] obstacleGrid) {
        // 思路：动态规划
        // 定义状态：f(i, j)代表从起始点到f(i, j)的路径数
        // 状态转移：
        // f(i, j) = 0 if obstacleGrid[i][j] = 1
        // f(i, j) = f[i-1][j] + f[i][j-1] if obstacleGrid[i][j] = 0
        // 空间优化：不开辟新空间，直接在原数组上操作

        int m = obstacleGrid.length;
        if( m == 0 )
            throw new IllegalArgumentException();
        int n = obstacleGrid[0].length;
        if( n == 0 )
            throw new IllegalArgumentException();
        if( obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 )
            return 0;

        // 在原始数组上操作
        // 初始化第一行
        for( int j = 0; j < n; j++ ) {
            if( obstacleGrid[0][j] == 1 ) {
                while( j < n ) {
                    obstacleGrid[0][j++] = 0;
                }
                break;
            }
            obstacleGrid[0][j] = 1;
        }

        // 初始化第一列
        for( int i = 1; i < m; i++ ) {
            if( obstacleGrid[i][0] == 1 ) {
                while( i < m ) {
                    obstacleGrid[i++][0] = 0;
                }
                break;
            }
            obstacleGrid[i][0] = 1;
        }

        // 动态规划DP
        for( int i = 1; i < m; i++ ) {
            for( int j = 1; j < n; j++ ) {
                if( obstacleGrid[i][j] == 1 )
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
            }
        }

        return obstacleGrid[m-1][n-1];
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        UniquePathsII solution = new UniquePathsII();
        System.out.println(solution.uniquePathsII(obstacleGrid));
    }
}
