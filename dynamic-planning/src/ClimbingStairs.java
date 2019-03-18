/**
 * Created by Nelson on 2019/3/17.
 */

/**
 * 70. Climbing stairs
 * https://leetcode.com/problems/climbing-stairs/
 */

public class ClimbingStairs {

    public int climbingStairs(int n) {
        // 思路：动态规划（斐波那契额数列）
        int[] memo = new int[n+1];

        // 初始化
        memo[0] = 1;
        memo[1] = 1;

        for( int i = 2; i <= n; i++ )
            memo[i] = memo[i-1] + memo[i-2];

        return memo[n];
    }

    public static void main(String[] args) {
        // 测试用例
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbingStairs(7));
    }
}
