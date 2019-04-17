/**
 * Created by Nelson on 2019/4/16.
 */

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class StockMaxProfitIII {

    public int maxProfit(int[] prices) {
        // 思路：动态规划
        // 状态：f(k, i)代表从prices[0...i]区间内至多进行k次交易能够取得的最大收益
        // 转移：1.当第i天不进行任何操作时，f(k, i) = f(k, i-1)
        // 2.当第i天进行sell时，意味着要在第j天买入( j < i )，此时在prices[j...i]阶段的收益为 prices[i]-prices[j]
        // 由于操作了一次，在[0...j)区间的最大收益为 f(k-1, j-1)
        // 因此 f(k, i) = Math.max( f(k, i-1), prices[i]-prices[j] + f(k-1, j-1) ) for j < i
        // 最终求解：f(2, prices.length-1)

        int n = prices.length;
        if( n <= 1 )
            return 0;

        // 这个问题里面k=2
        int k = 2;
        // 初始化dp
        int[][] dp = new int[k+1][n];
        // 第一列初始化为0，因此此时只有1个点

        for( int i = 1; i <= k; i++ ) {
            for( int j = 1; j < n; j++ ) {
                for( int p = 0; p < j; p++ ) {
                    dp[i][j] = Math.max(dp[i][j - 1], prices[j] - prices[p] + (p>=1? dp[i-1][p-1] : dp[i-1][p]) );
                }
            }
        }

        return dp[k][n-1];
    }

    public static void main(String[] args) {
        // 测试用例
        int[] prices = new int[]{3,3,5,0,0,3,1,4};

        StockMaxProfitIII solution = new StockMaxProfitIII();
        System.out.println(solution.maxProfit(prices));
    }
}
