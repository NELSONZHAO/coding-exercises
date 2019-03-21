/**
 * Created by Nelson on 2019/3/21.
 */

/**
 *
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        // 思路：由于nums中每个元素代表当前可以跳的"最大"步伐，因此需要确定每次跳多少
        // 最暴力的解法，无非把每一步可能跳的step都枚举出来，最后看看是否存在能够到达终点的方法
        // 我们假定一定能到达最后的格子，每次比较前面是否有能到达当前位置的点，如果有，就假定是从这个点跳过来的，继续向前找跳到这个点的人
        int n = nums.length;
        if( n <= 1 )
            return true;

        // 定义指针
        // i指向当前到达位置元素，初始化为最后一个元素
        int i = n - 1;
        // j指向跳到i的候选位置元素
        int j = i - 1;

        // 循环
        while( i > 0 && j >= 0 ) {
            // v代表当前j的元素值
            int v = nums[j];
            // d代表从j跳到i所需要的距离
            int d = i - j;

            // 如果j可以跳到i
            if( v >= d ) {
                i = j;
                j = i - 1;
            } else {
                // 如果不可以
                j--;
            }
        }

        // 判断跳出条件
        if( i == 0 ) {
            return true;
        }

        return false;

    }

    public static void main(String[] args){
        // 测试用例
        int[] nums = new int[]{2, 2, 0, 1, 3, 0, 1};
        JumpGame solution = new JumpGame();
        System.out.println(solution.canJump(nums));
    }
}
