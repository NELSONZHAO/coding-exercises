/**
 * Created by Nelson on 2019/9/14.
 */

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/
 */

import java.util.*;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // 思路：倒序遍历nums，找到第一对nums[i] < nums[i+1]，此时nums[i]为待交换元素
        // 从nums[i+1...len-1]区间找到比nums[i]大的最小元素nums[j]，交换nums[i]和nums[j]位置
        // 对nums[i+1...len-1]区间元素进行翻转
        int len = nums.length;
        if( len <= 1 )
            return;

        int i = len - 2;
        // 寻找待交换元素i
        while( i >= 0 && nums[i] >= nums[i+1] ) {
            i--;
        }

        // 如果无解
        if( i < 0 ) {
            Arrays.sort(nums);
            return;
        }

        // 寻找比nums[i]大的最小元素
        int minValue = Integer.MAX_VALUE;
        int minIdx = len-1;
        int j = len - 1;

        while( j > i ) {
            if( nums[j] > nums[i] && nums[j] < minValue ) {
                minValue = nums[j];
                minIdx = j;
            }
            j--;
        }

        // 交换元素
        nums[minIdx] = nums[i];
        nums[i] = minValue;

        // 翻转
        int l = i+1;
        int r = len-1;
        while( l < r ) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        return;
    }

    public static void main( String[] args ) {
        // 测试用例
        int[] nums = new int[]{2,3,1};
        for( int i = 0; i < nums.length; i++ )
            System.out.print(nums[i] + " ");
        System.out.println();

        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(nums);
        for( int i = 0; i < nums.length; i++ )
            System.out.print(nums[i] + " ");
    }
}
