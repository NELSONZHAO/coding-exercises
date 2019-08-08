/**
 * Created by Nelson on 2019/8/8.
 */

/**
 * 123. Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * 这个题相比于前两个题的区别在于，限制了至多进行两笔交易
 * 这个题我已开始想错了，我的思路是，统计连续升序区间的最大差值，这个数组中会存在多个连续升序区间，按照差值降序排序以后，取前两个求和就是最大利润
 * 这个思路不对的地方在于，第一个连续升序区间的最小值可能比第二个连续升序区间的最小值小，这样两个区间的极差之和比一次交易还要小
 * 思路：定义四个变量
 * buyFst: 第一笔买入时手里的钱，此时我们的利润为-price
 * sellFst: 第一笔卖出时手里的钱，此时我们的利润为buyFst + price
 * buySnd: 第二笔买入时手里的钱，此时我们的利润为sellFst - price
 * sellSnd: 第二笔买入时手里的钱，此时我们的利润为buySnd + price
 * 遍历整个数组，在每一次的遍历中，最大化上述四个变量，最后sellSnd就是我们的结果
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class BestTimeToBuyAndSellStocksIII {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if( len <= 1 )
            return 0;

        // 定义变量
        int buyFst = Integer.MIN_VALUE;
        int sellFst = 0;
        int buySnd = Integer.MIN_VALUE;
        int sellSnd = 0;

        // 遍历整个价格区间
        for( int i = 0; i < len; i++ ) {
            // 最大化四个变量
            buyFst = Math.max( buyFst, -prices[i] );
            sellFst = Math.max( sellFst, buyFst + prices[i] );
            buySnd = Math.max( buySnd, sellFst - prices[i] );
            sellSnd = Math.max( sellSnd, buySnd + prices[i] );
        }

        return sellSnd;
    }

    public static void main( String[] args ) {
        // 测试用例
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        BestTimeToBuyAndSellStocksIII solution = new BestTimeToBuyAndSellStocksIII();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
