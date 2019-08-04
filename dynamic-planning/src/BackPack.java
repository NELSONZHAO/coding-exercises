/**
 * Created by Nelson on 2019/8/3.
 */

/**
 * 0-1背包问题
 * 给定一个背包，容量为C，给定一系列候选物品，每个物品的重量为w[i], 价值为v[i]
 * 求放入背包中的物品，在重量和不超过容量C的前提下，能够获得的最大价值
 */
public class BackPack {

    public int backPack(int[] weights, int[] values, int C) {
        // 定义状态：f(i, c)代表在[0...i]个物品中挑选，放入容量为c的背包中所能获得的最大价值
        // 状态转移：对于第i个物品，可以选择放与不放
        // 假设放入背包，则f(i, c) = f(i-1, c-weights[i]) + values[i]
        // 假设不放入背包，则f(i, c) = f(i-1, c)
        // 则f(i, c) = max{f(i-1, c-weights[i]) + values[i], f(i-1, c)}
        // 时间复杂度：O(nC)
        // 空间复杂度：O(C)

        assert( weights.length == values.length );
        assert( C > 0 );

        // 物品个数
        int count = weights.length;

        // 初始化dp矩阵
        int[] dp = new int[C+1];

        // 对于矩阵第一行，即第一个物品，进行初始化
        for( int j = 1; j <= C; j++ ) {
            dp[j] = j >= weights[0] ? values[0] : 0;
        }

        // DP过程，其中i遍历物品，j遍历容量
        for( int i = 1; i < count; i++ ) {
            for( int j = C; j >= weights[i]; j-- ) {
                dp[j] = Math.max( dp[j], dp[j-weights[i]] + values[i] );
            }
        }

        return dp[C];
    }

    public static void main(String[] args) {
        // 测试用例
        int[] weights = new int[]{1, 2, 3};
        int[] values = new int[]{6, 10, 12};
        int C = 5;

        BackPack solution = new BackPack();
        System.out.println(solution.backPack(weights, values, C));
    }
}
