/**
 * Created by Nelson on 2019/5/2.
 */

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Using Brute Force and Two Pointers
 */

public class TrappingRainWater {

    // 思路1：暴力搜索
    public int trap1(int[] height) {
        // 思路：遍历求解每根柱子上可以承载的最大雨量
        // 对于任意一根柱子height[i]，它头上可以承载的最大雨量 = Math.min( 左侧最高柱子，右侧最高柱子 ） - height[i]
        // 时间复杂度：O(n2)

        int len = height.length;
        if ( len < 2 )
            return 0;

        int rainArea = 0;

        for( int i = 1; i < len - 1; i++ ) {
            // 初始化左右最高柱子
            int maxLeft = height[i];
            int maxRight = height[i];

            // 寻找左侧最高高度
            for( int l = i - 1; l >= 0; l-- ) {
                maxLeft = Math.max( maxLeft, height[l] );
            }

            // 寻找右侧最高高度
            for( int r = i + 1; r < len; r++ ) {
                maxRight = Math.max( maxRight, height[r] );
            }

            // 更新
            rainArea += Math.min( maxLeft, maxRight ) - height[i];
        }

        return rainArea;
    }

    // 思路2：双指针
    public int trap2(int[] height) {
        // 思路：在上面暴力搜索中，我们重复搜索了元素的左侧最大值和右侧最大值，这些重复操作可以省去
        // 对于每个柱子上面能够存储的最大雨量，是由左右柱子的最小值所决定的；因此，如果左侧最大值总是小于右侧最大值时，我们只需要关心左侧就好
        // 同理，右侧最大值总是小于左侧最大值时，我们只需要关心右侧就好

        int len = height.length;
        if ( len < 2 )
            return 0;

        int rainArea = 0;
        int l = 0;
        int r = len - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while( l < r ) {
            // 当左侧指针对应的高度较小时，我们只需要关注左侧就好
            if( height[l] < height[r] ) {
                if( height[l] > maxLeft )
                    maxLeft = height[l];
                else
                    rainArea += maxLeft - height[l];
                // 移动指针
                l++;
            } else {
                if( height[r] > maxRight )
                    maxRight = height[r];
                else
                    rainArea += maxRight - height[r];
                // 移动指针
                r--;
            }
        }

        return rainArea;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap1(height));
        System.out.println(solution.trap2(height));
    }
}
