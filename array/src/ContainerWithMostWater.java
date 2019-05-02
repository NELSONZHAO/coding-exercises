/**
 * Created by Nelson on 2019/5/2.
 */

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        // 思路：对撞指针
        // 时间复杂度：O(n)
        int len = height.length;
        if( len < 2 )
            return 0;

        // [l, r]区间内能容纳的最大水位为 min(height[l], height[r]) * (r-l)
        int l = 0;
        int r = len - 1;
        int currMin = 0;
        int maxArea = 0;

        // 遍历数组更新最大面积
        while( l < r ) {

            // 更新面积
            maxArea = Math.max( maxArea, Math.min(height[l], height[r]) * (r - l) );

            // 如果当前左侧高度较小，右侧柱子较高
            // 此时需要移动左侧柱子，看看右边有没有比它更高的柱子以此来增加容量
            // 记录当前左侧柱子的索引，去看它右边是否有>它的
            // 如果左柱子右侧的柱子高度<=它，container的容量只会减小不会增加（因为宽度在减少，而高度没有增加）
            // 直到找到当前比较高的柱子，停止搜索
            if( height[l] < height[r] ) {
                currMin = l;
                while( l < r && height[++l] <= height[currMin] );
            } else {
                // 右侧柱子移动逻辑同理
                currMin = r;
                while( l < r && height[--r] <= height[currMin] );
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(height));
    }
}
