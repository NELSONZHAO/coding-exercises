/**
 * Created by Nelson on 2019/3/19.
 */

/**
 * 494. Target Sum
 * https://leetcode.com/problems/target-sum/
 * nums.length <= 20
 * nums.sum() <= 1000
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        // 思路：动态规划
        // 定义状态：f(i, s)代表nums[0...i]的元素构成和为s的方法数量
        // 状态转移：f(i, s) = f(i-1, s-nums[i]) + f(i-1, nums[i]-s)
        // 注意点：0到0是有两种方案，因为加正负号还是0

        int n = nums.length;
        if( n == 0 )
            throw new IllegalArgumentException();

        // 求和
        int sum = 0;
        for( int i = 0; i < n; i ++ )
            sum += nums[i];

        // 保证S的绝对值要<=sum
        if( S > sum || S < - sum )
            return 0;

        // 初始化矩阵
        // n行代表数组元素索引，2*sum+1代表[-sum, sum]区间
        int[][] memo = new int[n][2*sum+1];

        // 初始化第一行：如果当前元素的绝对值等于列的和则置为1
        for( int j = 0; j < 2 * sum + 1; j++ ) {
            if( nums[0] == j - sum || -nums[0] == j - sum )
                memo[0][j] = nums[0] == 0 ? 2 : 1;
        }

        // 动态规划DP
        for( int i = 1; i < n; i++ ) {
            for( int j = 0; j < 2 * sum + 1; j++ ) {
                memo[i][j] = (j + nums[i] < 2 * sum + 1 ? memo[i-1][j+nums[i]] : 0) + (j - nums[i] >= 0 ? memo[i-1][j-nums[i]] : 0);
            }
        }

        return memo[n-1][S+sum];
    }

    public static void main(String[] args){
        // 测试用例
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int S = 5;

        TargetSum solution = new TargetSum();
        System.out.println(solution.findTargetSumWays(nums, S));


        int[] nums2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1};
        int S2 = 1;

        System.out.println(solution.findTargetSumWays(nums2, S2));
    }
}
