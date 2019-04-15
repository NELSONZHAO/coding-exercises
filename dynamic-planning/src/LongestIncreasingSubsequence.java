/**
 * Created by Nelson on 2019/4/15.
 */

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */

import java.util.*;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        // 思路：动态规划
        // 状态：LIS(i)代表以nums[i]结尾的最长上升子序列长度
        // 转移：LIS(i) = max{ 1 + LIS(j) if nums[i] > nums[j] } for j < i
        // 时间复杂度：O(n2)
        // 空间复杂度：O(n)

        int len = nums.length;
        if( len == 0 )
            return 0;

        // 初始化
        int[] lis = new int[len];
        Arrays.fill(lis, 1);

        int ret = 1;

        for( int i = 0; i < len; i++ ) {
            for( int j = 0; j < i; j++ ) {
                if( nums[i] > nums[j] ) {
                    lis[i] = Math.max( lis[i], lis[j]+1 );
                }

                ret = Math.max( ret, lis[i] );
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        System.out.println(solution.lengthOfLIS(nums));
    }
}
