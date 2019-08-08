/**
 * Created by Nelson on 2019/8/9.
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit( int[] prices ) {
        // 定义状态：
        // buy[i]代表[0...i]区间内，以buy结尾的一次交易所获得的最大利润
        // sell[i]代表[0...i]区间内，以sell结尾的一次交易所获得的最大利润
        // 状态转移：
        // buy[i] = max{ buy[i-1], sell[i-2] - prices[i] }
        // sell[i] = max{ sell[i-1], buy[i-1] + prices[i] }

        // 时间复杂度：O(n)
        // 空间复杂度：O(1)

        int len = prices.length;
        if( len <= 1 )
            return 0;

        //
        int[] b = new int[len];
        int[] s = new int[len];

        b[0] = -prices[0];
        s[0] = 0;

        b[1] = Math.max( b[0], -prices[1] );
        s[1] = Math.max( s[0], b[0] + prices[1] );

        // dp
        for( int i = 2; i < len; i++ ) {
            // 更新buy和sell
            b[i] = Math.max( b[i-1], s[i-2] - prices[i] );
            s[i] = Math.max( s[i-1], b[i-1] + prices[i] );
        }

        return s[len-1];
    }
}
