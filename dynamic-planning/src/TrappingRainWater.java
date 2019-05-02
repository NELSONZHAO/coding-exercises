/**
 * Created by Nelson on 2019/5/2.
 */

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Using Dynamic Programming
 */
public class TrappingRainWater {

    public int trap( int[] height ) {
        // 思路：动态规划
        // 定义状态：maxLeft[i]代表[0...i]区间内最大高度; maxRight[i]代表[i...len-1]区间最大高度
        // 状态转移：maxLeft[i] = Math.max( maxLeft[i-1], height[i] ); maxRight[i] = Math.max( maxRight[i-1], height[i] )
        // 时间复杂度：O(n)
        int len = height.length;
        if( len < 2 )
            return 0;

        int rainArea = 0;

        // maxLeft[i]代表[0...i]区间最大高度
        int[] maxLeft = new int[len];
        // maxRight[i]代表[i...len-1)区间最大高度
        int[] maxRight = new int[len];

        // 求解maxLeft和maxRight
        maxLeft[0] = height[0];
        for( int i = 1; i < len; i++ ) {
            maxLeft[i] = Math.max( maxLeft[i-1], height[i] );
        }
        maxRight[len-1] = height[len-1];
        for( int i = len - 2; i >= 0; i-- ) {
            maxRight[i] = Math.max( maxRight[i+1], height[i] );
        }

        for( int i = 1; i < len - 1; i++ ) {
            rainArea += Math.min( maxLeft[i], maxRight[i] ) - height[i];
        }

        return rainArea;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(height));
    }
}
