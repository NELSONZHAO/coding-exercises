/**
 * Created by Nelson on 2019/3/12.
 */

/**
 * 303. Range Sum Query
 * https://leetcode.com/problems/range-sum-query-immutable/
 */

public class RangeSumQuery {

    // 思路：存储从[0...i)的所有和，返回memo[j+1]-memo[i]即可

    int memo[];

    public RangeSumQuery(int[] nums) {
        if( nums.length == 0 )
            throw new IllegalArgumentException();

        // 初始化memo
        memo = new int[nums.length + 1];

        // memo存储[0...i)的和
        for( int i = 1 ; i <= nums.length; i++ ) {
            memo[i] = memo[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if( i < 0 || j < 0 || i > j )
            throw new IllegalArgumentException();

        return memo[j+1] - memo[i];
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{-2, 0, 3, 5, -1, 2, -7};

        // 测试
        RangeSumQuery solution = new RangeSumQuery(nums);
        System.out.println(solution.sumRange(0, 4));
        System.out.println(solution.sumRange(3, 4));
    }
}
