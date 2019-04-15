/**
 * Created by Nelson on 2019/4/14.
 */

import org.omg.PortableInterceptor.INACTIVE;

/**
 * 1027. Longest Arithmetic Sequence
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 */
public class LongestArithSeqLength {

    public int longestArithSeqLength(int[] A) {
        // 思路：动态规划
        int len = A.length;
        if( len == 0 )
            return 0;

        // 状态：f(diff, i)代表以A[i]结尾的，以diff为等差的数组长度
        // 转移：f(diff, i) = f(diff, j) + 1 if nums[i] - nums[j] = diff and j < i

        // 找到数组的极差
        int min = Integer.MAX_VALUE;
        int max = 0;

        for( int i = 0; i < len; i++ ) {
            min = Math.min( min, A[i] );
            max = Math.max( max, A[i] );
        }

        int diff = max - min;

        // 初始化数组dp
        int[][] dp = new int[2*diff+1][len];
        // 初始化第一列
        for( int i = 0; i < 2*diff+1; i++ ) {
            dp[i][0] = 0;
        }

        // 动态规划求解
        int ret = 0;

        // 遍历所有元素
        for( int i = 1; i < len; i++ ) {
            for( int j = 0; j < i; j++ ) {
                // 求diff
                int d = A[i] - A[j];
                int dIndex = d + diff;
                dp[dIndex][i] = Math.max( dp[dIndex][i], dp[dIndex][j] + 1 );

                ret = Math.max( ret, dp[dIndex][i] + 1 );
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{3, 6, 8, 9, 12};
        LongestArithSeqLength solution = new LongestArithSeqLength();
        System.out.println(solution.longestArithSeqLength(arr));
    }
}
