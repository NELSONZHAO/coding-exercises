/**
 * Created by Nelson on 2019/4/17.
 */

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class StockMaxProfit {

    public int maxProfit(int[] prices) {
        // 思路：可以采用O(n2)时间复杂度进行双重循环求解
        // 进阶：由于限制了最多一次交易，所以去找最低谷后面的peak，然后得到profit
        // 时间复杂度：O(n)
        int n = prices.length;
        if( n == 0 )
            return 0;

        // 返回值
        int ret = 0;
        int valley = Integer.MAX_VALUE;
        int peak = 0;

        for( int i = 0; i < n; i++ ) {
            // 判断当前价格
            // 如果比当前最小值小，更新新的valley
            if( prices[i] < valley ) {
                valley = prices[i];
            } else {
                if( prices[i] - valley > ret )
                    ret = prices[i] - valley;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        StockMaxProfit solution = new StockMaxProfit();
        System.out.println(solution.maxProfit(prices));
    }
}
