/**
 * Created by Nelson on 2019/3/10.
 */

import java.util.Arrays;

/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 * 给定一个m x n的矩阵，代表m x n个格子，试求从左上角到右下角的路径数，其中agent每次只可以下移或者右移一步。
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        // 思路：动态规划
        // 定义状态：f(i, j)代表从起始点到(i, j)位置的路径数
        // 状态转移：f(i, j) = f(i-1, j) + f(i, j-1)
        // 问题优化：原本需要memo[m][n]的矩阵进行DP状态，但实际上可以只使用有n个元素的一维数组，降低空间复杂度
        // 时间复杂度：O(mn)
        // 空间复杂度：O(n)

        if( m <= 0 || n <= 0 )
            throw new IllegalArgumentException();

        // 初始化状态矩阵
        int[] memo = new int[n];

        // 初始化
        Arrays.fill(memo, 1);

        // 状态转移DP
        for( int i = 1; i < m; i++ ) {
            for (int j = 1; j < n; j++) {
                memo[j] = memo[j] + memo[j-1];
            }
        }

        return memo[n-1];

    }

    public static void main(String[] args) {
        // 测试用例
        int m = 10;
        int n = 7;

        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(m, n));
    }
}
