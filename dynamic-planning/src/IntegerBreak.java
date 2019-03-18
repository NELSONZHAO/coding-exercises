/**
 * Created by Nelson on 2019/3/18.
 */

/**
 * 343. Integer Break
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {

    public int IntegerBreak(int n) {
        // 动态规划
        // 定义状态：f(n)代表n的最大分割后的乘积
        // 状态转移：f(n) = max{f(n-1) * 1, f(n-2) * 2, ... , f(1) * n-1}

        if( n <= 0 )
            return 0;

        // 初始化状态数组
        int[] memo = new int[n+1];

        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        // DP
        for( int i = 3; i <= n; i++ ) {
            for( int j = 1; j <= i-1; j++ ) {
                memo[i] = Math.max( memo[i], Math.max( (i-j) * j, memo[i-j] * j ));
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        // 测试用例
        int n = 10;
        IntegerBreak solution = new IntegerBreak();
        System.out.println(solution.IntegerBreak(n));
    }
}
