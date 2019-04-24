/**
 * Created by Nelson on 2019/4/24.
 */

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        // 思路：三路快排思想
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)
        int len = nums.length;
        if( len == 0 )
            return;

        // 选择1为anchor
        // 使得[0...lt] = 0, [lt+1...i) = 1,  [gt...len-1] = 2
        int lt = -1;
        int gt = len;
        int i = 0;

        // 遍历数组
        while( i < gt ) {
            // 逐个元素判断
            if( nums[i] == 0 ) {
                // 交换lt+1和i
                int temp = nums[lt+1];
                nums[lt+1] = nums[i];
                nums[i] = temp;
                // 移动指针
                lt++;
                i++;
            } else if( nums[i] == 1 ) {
                i++;
            } else {
                // nums[i] == 2
                int temp = nums[i];
                nums[i] = nums[gt-1];
                nums[gt-1] = temp;

                gt--;
            }
        }

        return;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{0, 1, 1, 2, 0, 2, 0, 1};
        SortColors solution = new SortColors();
        solution.sortColors(nums);

        for( int n : nums )
            System.out.print(n + " ");
    }
}
