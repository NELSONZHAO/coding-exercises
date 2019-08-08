/**
 * Created by Nelson on 2019/8/8.
 */

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 这个题相比于121题的区别是，可以进行多次交易，而非一次交易，但同时只可以进行一笔交易（即当前如果有未卖出的股票，不允许买入新的股票）
 * 这个题其实是通过小trick解决的。我们以[7,1,5,3,6,4]为例，横坐标为第i天，纵坐标为对应的股票价格
 * 可以画出一条折现，由于可以进行多次交易，那么我们只要在价格连续升高的区域[l...r]中，在第l天买入，第r天卖出即可
 * 所以这个题就转化成求数组中连续升高区域的delta之和
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class BestTimeToBuyAndSellStocksII {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if( len <= 1 )
            return 0;

        // 初始胡
        int maxProfit = 0;

        for( int i = 1; i < len; i++ ) {
            // 如果出现连续升高区间
            if( prices[i] > prices[i-1] ) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        BestTimeToBuyAndSellStocksII solution = new BestTimeToBuyAndSellStocksII();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
