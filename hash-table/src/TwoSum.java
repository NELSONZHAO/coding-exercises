/**
 * Created by Nelson on 2019/5/13.
 */

import java.util.*;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * 这个题和TwoSumII的区别在于，TwoSumII是有序数组，可以使用对撞指针或者二分查找
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // 思路：查找表
        // 对于nums中的数组，构建 nums[i] -> i 的查找表
        // 遍历nums，查找target-nums[i]的索引
        int len = nums.length;
        if( len == 0 )
            return new int[]{};

        Map<Integer, Integer> hashMap = new HashMap<>();
        // 这样做会使得后面出现与nums[i]相同的值时，覆盖掉之前的索引
        // 因此实际上hashMap保留的是值为nums[i]的最后一次出现的索引
        for( int i = 0; i < len; i++ ) {
            hashMap.put(nums[i], i);
        }

        // 遍历
        for( int i = 0; i < len; i++ ) {
            int e = target - nums[i];
            if( hashMap.containsKey(e) && hashMap.get(e) != i ) {
                return new int[]{i, hashMap.get(e)};
            }
        }

        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        // 思路：维持某个窗口的查找表
        // 遍历一遍数组即可
        // 对于当前i位置的元素e，维持一张查找表，存储了[0...i)元素的查找表
        // 先判断e是不是在查找表中，如果在，就返回结果；否则将e纳入查找表，继续往下
        // 好处：可以提前结束，且仅遍历数组一遍

        int len = nums.length;
        if( len == 0 )
            return new int[]{};

        Map<Integer, Integer> hashMap = new HashMap<>();

        for( int i = 0; i < len; i++ ) {
            int e = target - nums[i];
            // 判断e是否在查找表中
            if( hashMap.containsKey(e) ) {
                return new int[]{hashMap.get(e), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{2, 7, 15, 1};
        int target = 9;
        TwoSum solution = new TwoSum();
        int[] ret = solution.twoSum(nums, target);

        System.out.println(ret[0] + ", " + ret[1]);
    }
}
