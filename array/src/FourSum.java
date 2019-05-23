/**
 * Created by Nelson on 2019/5/23.
 */

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 */
import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 思路：排序，使用3Sum的思路
        // 时间复杂度：O(n3)
        List<List<Integer>> ret = new ArrayList<>();

        int len = nums.length;
        if( len == 0 )
            return ret;

        // 1.排序
        Arrays.sort(nums);

        // 2.遍历
        for( int i = 0; i < len; i++ ) {

            // 去除i的重复项
            if( i > 0 && nums[i] == nums[i-1] )
                continue;

            // 3Sum
            for( int j = i + 1; j < len; j++ ) {
                if( j > i + 1 && nums[j] == nums[j-1] )
                    continue;

                // 双指针
                int l = j + 1;
                int r = len - 1;

                int residual = target - nums[i] - nums[j];

                while( l < r ) {
                    // 2Sum，寻找元素使得nums[l] + nums[r] == residual
                    if( nums[l] + nums[r] == residual ) {
                        // 存储2Sum结果
                        List<Integer> subList = new ArrayList<>();

                        // 添加元素
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[l]);
                        subList.add(nums[r]);

                        ret.add(subList);
                        // 移动重复元素
                        while( l < r && nums[l] == nums[l+1] ) {
                            l++;
                        }

                        while( l < r && nums[r] == nums[r-1] ) {
                            r--;
                        }

                        // 移动指针
                        l++;
                        r--;
                    } else if( nums[l] + nums[r] < residual ){
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;

        FourSum solution = new FourSum();
        List<List<Integer>> ret = solution.fourSum(nums, target);

        for( int i = 0; i < ret.size(); i++ ) {
            for( int j = 0; j < ret.get(i).size(); j++ ) {
                System.out.print(ret.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
