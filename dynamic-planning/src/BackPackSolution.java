/**
 * Created by Nelson on 2019/8/4.
 */

/**
 * 0-1背包问题，要求返回具体的解
 */

import java.util.*;
public class BackPackSolution {

    public int[] backPack(int[] weights, int values[], int C) {
        // 定义状态：dp[i][j]代表考虑[0...i]个物品放入容量为j的背包中所能带来的最大价值
        // 状态转移：dp[i][j] = max{dp[i-1][j], dp[i-1][j-w[i]]+v[i]}
        assert (weights.length == values.length);
        if( C <= 0 )
            return null;

        int n = weights.length;
        int[][] dp = new int[n][C+1];
        // 初始化第一行
        for( int j = 0; j <= C; j++ ) {
            dp[0][j] = j >= weights[0] ? values[0] : 0;
        }

        // 进行动态规划
        for( int i = 1; i < n; i++ ) {
            for( int j = 1; j <=C ; j++ ) {
                dp[i][j] = dp[i-1][j];
                if( j >= weights[i] )
                    dp[i][j] = Math.max( dp[i][j], dp[i-1][j-weights[i]] + values[i] );
            }
        }

        // 此时背包dp[n-1][C]为最优解的价值，此时开始逆向求解
        List<Integer> items = new ArrayList<>();

        int i = n-1;
        int j = C;
        while( i >= 0 && j >= 0 ) {
            // 取出当前格子总价值
            int v = dp[i][j];

            // 判断当前第i个物品是否加入
            // 若dp[i][j] == dp[i-1][j]，说明当前物品i没有加入
            if( i - 1 >= 0 && v == dp[i-1][j] ) {
                i = i - 1;
            } else if( i - 1 >= 0 && j >= weights[i] && v == dp[i-1][j-weights[i]] + values[i] ) {
                // 说明第i个物品加入了
                items.add(i);
                // 更改索引
                i = i - 1;
                j = j - weights[i];
            } else {
                if( i == 0 && v == values[i] ) {
                    items.add(i);
                }
                break;
            }
        }

        int[] res = new int[items.size()];
        for( int k = 0 ; k < items.size(); k++ ) {
            res[k] = items.get(k);
        }
        return res;
    }


    public static void main(String[] args) {
        // 测试用例
        int[] weights = new int[]{2, 3, 4, 5};
        int[] values = new int[]{3, 4, 5, 7};
        int C = 9;

        BackPackSolution solution = new BackPackSolution();
        int[] res = solution.backPack(weights, values, C);

        for( int i = 0; i < res.length; i++ ) {
            System.out.println(res[i] + " weight: " + weights[res[i]] + " value: " + values[res[i]]);
        }
    }
}
