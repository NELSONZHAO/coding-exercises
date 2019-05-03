/**
 * Created by Nelson on 2019/5/3.
 */

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        // 思路：对撞指针+滑动窗口（最基本思路是暴力解法，用双循环）
        // 当[l...r]区间中元素>=s时，移动l，并更新返回值；否则不停移动r
        // 时间复杂度：O(n)
        assert s > 0;

        int len = nums.length;

        int l = 0;
        int r = -1;
        int subSum = 0;
        int ret = len + 1;

        while( l < len && r < len ) {

            // 当[l...r]区间内元素>=s时，更新ret
            if( subSum >= s ) {
                ret = Math.min( ret, r - l + 1 );
                subSum -= nums[l++];
            } else {
                if( r == len - 1 )
                    break;
                subSum += nums[++r];
            }
        }

        return  ret == len + 1 ? 0 : ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};

        MinSubArrayLen solution = new MinSubArrayLen();
        System.out.println(solution.minSubArrayLen(s, nums));
    }
}
