/**
 * Created by Nelson on 2019/6/30.
 */

import java.util.*;

/**
 * 1105. Filling Bookcase Shelves
 * https://leetcode.com/problems/filling-bookcase-shelves/
 */
public class MinHeightShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        // 动态规划
        // 定义状态：dp[i]代表前i本书按顺序放书架的最小高度
        // 状态转移1：把新的第i本书放在新的一层，则dp1: dp[i] = dp[i-1] + h[i];
        // 状态转移2：尝试将第[j+1...i]本书放在一层，前j本书放在一层，则dp2: dp[i] = dp[j] + Math.max({h[j+1], ..., h[i]})，其中
        // sumWidth{h[j+1],... h[i]} <= shelf_width
        // 最终转移：dp[i] = Math.min(dp1, dp2);

        if( books.length == 0 || shelf_width == 0 )
            return 0;

        // 定义数组
        int[] dp = new int[books.length+1];

        // 动态规划更新
        for( int i = 1; i <= books.length; i++ ) {
            // 第一种情况
            dp[i] = dp[i-1] + books[i-1][1];
            // 记录当前所有在同一层书的宽度之和
            int totalWidths = 0;
            // 记录当前放在同一层书的最大高度
            int maxH = 0;

            for( int j = i; j >= 1; j-- ) {
                // 更新宽度之和
                totalWidths += books[j-1][0];
                // 更新最大高度
                maxH = Math.max( maxH, books[j-1][1] );

                // 判断是否满足宽度
                if( totalWidths > shelf_width ) {
                    break;
                } else {
                    dp[i] = Math.min( dp[i], dp[j-1] + maxH );
                }
            }
        }

        return dp[books.length];
    }

    public static void main(String[] args) {
        int[][] books = new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelf_width = 4;

        MinHeightShelves solution = new MinHeightShelves();
        int ret = solution.minHeightShelves(books, shelf_width);
        System.out.print(ret);
    }
}
