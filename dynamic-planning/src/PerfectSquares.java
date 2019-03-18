/**
 * Created by Nelson on 2019/3/18.
 */

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/
 */

import java.util.*;

public class PerfectSquares {

    public int numSquares(int n) {
        // 思路：动态规划
        // 状态定义：f(n)代表组成n的最少完全平方数的个数
        // 状态转移：f(n) = max{f(n-1)+1, f(n-4)+1, ... , f(n-s)+1}

        if( n <= 0 )
            return 0;

        // 初始化状态
        int[] memo = new int[n+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        memo[1] = 1;

        // DP
        for( int i = 2; i <= n; i++ ) {
            for( int j = 1; j <= Math.sqrt(i); j++ ) {
                memo[i] = Math.min( memo[i], memo[i-j*j] + 1 );
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        // 测试用例
        int n = 7;
        PerfectSquares solution = new PerfectSquares();
        System.out.println(solution.numSquares(n));
    }
}
