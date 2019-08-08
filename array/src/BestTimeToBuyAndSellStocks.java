/**
 * Created by Nelson on 2019/8/8.
 */

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 限制：只能进行一次交易
 * 思路：只能进行一次交易，使得利润最大，其实就是等价于在一个数组中找到极差最大的顺序对（小的数在前，大的数在后）
 * 我们考虑第i天的价格卖出，那么我们需要找到[0...i-1]天的最低价格，就使得我们如果在第i天卖出时利润最大。
 * 推广到整个数组，我们只需要遍历所有元素，计算在当前第i个元素对应的价格和在i之前的最小值的差，对这些差取最大即可
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class BestTimeToBuyAndSellStocks {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if( len <= 1 )
            return 0;

        // 初始化
        int maxProfit = 0;
        int minPrice = prices[0];

        for( int i = 1; i < len; i++ ) {
            // 计算当前i天卖出时的利润
            int profit = prices[i] - minPrice;
            // 比较利润大小
            maxProfit = Math.max( maxProfit, profit );
            // 更新最小值
            minPrice = Math.min( minPrice, prices[i] );
        }

        return maxProfit;
    }

    public static void main( String[] args ) {
        int[] prices = new int[]{1, 2, 3, 4, 5};
        BestTimeToBuyAndSellStocks solution = new BestTimeToBuyAndSellStocks();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
