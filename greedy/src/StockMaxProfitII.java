/**
 * Created by Nelson on 2019/4/16.
 */

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class StockMaxProfitII {

    public int maxProfit(int[] prices) {
        // 思路：贪心算法
        // 选择连续递增序列进行delta的计算
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)

        int n = prices.length;
        if( n == 0 )
            return 0;

        int ret = 0;

        for( int i = 0; i < n - 1; i++ ) {
            if( prices[i] < prices[i+1] )
                ret += prices[i+1] - prices[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        StockMaxProfitII solution = new StockMaxProfitII();
        System.out.println(solution.maxProfit(prices));
    }
}
