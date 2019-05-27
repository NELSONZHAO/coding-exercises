/**
 * Created by Nelson on 2019/5/27.
 */

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 */

import java.util.*;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        // 思路：排序，求3Sum问题
        int len = nums.length;
        if( len == 1 )
            return nums[0];

        // 1.排序
        Arrays.sort(nums);

        // 2.3Sum
        int minDelta = Integer.MAX_VALUE;

        for( int i = 0; i < len; i++ ) {
            // 剔除重复计算
            if( i > 0 && nums[i] == nums[i-1] )
                continue;

            // 双指针对撞
            int l = i + 1;
            int r = len - 1;

            // 寻找nums[i] + nums[l] + nums[r]与target的最小差距

            while( l < r ) {
                int delta = nums[i] + nums[l] + nums[r] - target;

                // 更新minDelta
                minDelta = Math.abs(delta) < Math.abs(minDelta) ? delta : minDelta;

                // 判断delta
                if( delta > 0 ) {
                    r--;
                } else if ( delta < 0 ) {
                    l++;
                } else {
                    return target;
                }
            }
        }

        return target + minDelta;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;

        ThreeSumClosest solution = new ThreeSumClosest();
        int ret = solution.threeSumClosest(nums, target);

        System.out.println(ret);
    }
}
