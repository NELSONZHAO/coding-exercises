/**
 * Created by Nelson on 2019/4/28.
 */

/**
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {

    // 遇到有序数组，需要首先想到对撞指针和二分搜索

    // 解法1：对撞指针
    public int[] twoSum1(int[] numbers, int target) {
        // 由于数组有序，因此可以采用对撞指针进行求解
        // 时间复杂度：O(n)

        int len = numbers.length;

        // 设置指针
        int l = 0;
        int r = len - 1;

        while( l < r ) {
            // 求解
            int sum = numbers[l] + numbers[r];

            if( sum == target )
                return new int[]{l+1, r+1};
            else if( sum > target ) {
                // sum比target大，移动右指针
                r--;
            } else {
                // sum比target小，移动左指针
                l++;
            }
        }

        return null;
    }

    // 二分搜索法
    public int[] twoSum2(int[] numbers, int target) {
        // 二分查找法，对每一个元素，在数组剩余部分进行二分搜索
        // 时间复杂度：O(nlogn)

        int len = numbers.length;

        for( int i = 0; i < len - 1; i++ ) {
            // 在剩余部分进行二分搜索
            int residual = target - numbers[i];

            int j = helper(numbers, i+1, len-1, residual);

            if( j != -1 )
                return new int[]{i+1, j+1};
        }

        return null;

    }

    private int helper(int[] numbers, int l, int r, int target) {
        // 在numbers[l...r]区间内搜索target

        while( l <= r ) {
            int mid = l + (r-l)/2;

            if( target == numbers[mid] ) {
                return mid;
            } else if( target > numbers[mid] ) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        // 测试用例
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        TwoSumII solution = new TwoSumII();
        int[] ret1 = solution.twoSum1(numbers, target);
        System.out.println(ret1[0] + ", " + ret1[1]);

        int[] ret2 = solution.twoSum2(numbers, target);
        System.out.println(ret2[0] + ", " + ret2[1]);

    }
}
