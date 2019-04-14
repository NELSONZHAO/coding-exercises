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
        // 转移：f(diff, i) = Math.max(f(diff, 0), f(diff, 1) ... f(diff, i-1)) + 1

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

        // 动态规划求解
        int ret = 0;

        for( int i = 0; i < len; i++ ) {
            for( int j = i + 1; j < len; j++ ) {
                int d = A[j] - A[i];
                int dIndex = d + diff;
                dp[dIndex][j] = Math.max( dp[dIndex][j], dp[dIndex][i] + 1 );
                ret = Math.max( ret, dp[dIndex][j] + 1 );
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
