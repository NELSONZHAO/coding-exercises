/**
 * Created by Nelson on 2019/5/14.
 */

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // 思路：排序后，再使用对撞指针
        // 时间复杂度：O(n2)
        int len = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> ret = new ArrayList<>();

        // 双指针，l,r都在当前元素i之后，寻找使得nums[i] + nums[l] + nums[r] = 0的三元组
        for( int i = 0; i < len; i++ ) {
            // 指针
            int l = i + 1;
            int r = len - 1;

            // 不考虑重复三元组
            if( i > 0 && nums[i] == nums[i-1] )
                i++;

            // 在滑动窗口中寻找
            while( l < r ) {
                int sum = nums[i] + nums[l] + nums[r];

                if( sum == 0 ) {
                    List<Integer> subArray = new ArrayList<>();
                    subArray.add(nums[i]);
                    subArray.add(nums[l]);
                    subArray.add(nums[r]);

                    ret.add(subArray);

                    // 过滤掉重复指针
                    while( l < r && nums[l+1] == nums[l] )
                        l++;
                    while( l < r && nums[r-1] == nums[r] )
                        r--;

                    l++;
                    r--;
                } else if( sum > 0 ) {
                    r--;
                } else {
                    l++;
                }

            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum solution = new ThreeSum();

        List<List<Integer>> ret = solution.threeSum(nums);

        for( int i = 0; i < ret.size(); i++ ) {
            List<Integer> r = ret.get(i);
            System.out.println(r.get(0) + "," + r.get(1) + "," + r.get(2));
        }
    }
}
