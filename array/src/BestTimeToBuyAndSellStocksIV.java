/**
 * Created by Nelson on 2019/8/10.
 */

/**
 * 188. Best Time to Buy and Sell Stock IV
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * 这个题相比于前几道题的限制在于，给定最多交易k次的情况下，能够获得的最大收益
 * 思路：采用动态规划
 * 定义状态：
 * hold[i][j]代表在[0...i]天最多进行j次交易，且手中hold了一支股票的情况下，能够获得的最大收益（一次完整的交易为卖出）
 * unhold[i][j]代表在[0...i]天最多进行j词交易，且手中没有hold一支股票的情况下，能够获得的最大收益
 * 状态转移：
 * hold[i][j] = Math.max( hold[i-1][j], unhold[i-1][j] - prices[i] )
 * unhold[i][j] = Math.max( unhold[i-1][j], hold[i-1][j-1] + prices[i] )
 */
public class BestTimeToBuyAndSellStocksIV {

    public int maxProfit( int[] prices, int k ) {
        // 时间复杂度：O(nk)
        // 空间复杂度：O(nk)

        int n = prices.length;
        // 处理特殊情况，当对于prices来说，k是无限次交易时
        if( k > n / 2 ) {
            int res = 0;
            for( int i = 1; i < n; i++ ) {
                res += prices[i] > prices[i-1] ? prices[i] - prices[i-1] : 0;
            }

            return res;
        }

        // 定义状态
        int[][] hold = new int[n][k+1];
        int[][] unhold = new int[n][k+1];

        // 初始化hold
        hold[0][0] = -prices[0];
        // 第一行
        for( int j = 1; j <= k; j++ ) {
            hold[0][j] = -prices[0];
        }
        // 第一列
        for( int i = 1; i < n; i++ ) {
            hold[i][0] = Math.max( hold[i-1][0], -prices[i] );
        }

        // DP
        for( int i = 1; i < n; i++ ) {
            for( int j = 1; j <= k; j++ ) {
                hold[i][j] = Math.max( hold[i-1][j], unhold[i-1][j] - prices[i] );
                unhold[i][j] = Math.max( unhold[i-1][j], hold[i-1][j-1] + prices[i] );
            }
        }

        return unhold[n-1][k];
    }

    public static void main( String[] args ) {
        int[] prices = new int[]{3,2,6,5,0,3};
        int k = 2;

        BestTimeToBuyAndSellStocksIV solution = new BestTimeToBuyAndSellStocksIV();
        System.out.println(solution.maxProfit(prices, k));
    }
}
