/**
 * Created by Nelson on 2019/4/22.
 */

/**
 * 1031. Maximum Sum of Two Non-Overlapping Subarrays
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
 */
public class MaxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] A, int L, int M){
        // 思路：
        // maxL：代表当前最近M个连续元素之前 长度为L的连续最大和
        // maxM：代表当前最近L个连续元素之前 长度为M的连续最大和
        int len = A.length;
        if( L + M > len )
            return -1;

        // 累加数组A的和，使得A[i]代表[0...i]之和
        // 这种情况下，任意两点之间的差值就可以很容易计算出来
        for( int i = 1; i < len; i++ ) {
            A[i] += A[i-1];
        }

        // 初始化参数
        int ret = A[L+M-1];  // 初始化为前L+M个连续元素和
        int maxL = A[L-1];  // 初始化为前L个连续元素之和
        int maxM = A[M-1];  // 初始化为前M个连续元素之和

        // 由于ret初始化为前L+M个元素，则从L+M+1个元素开始遍历
        for( int i = L + M; i < len; i++ ) {
            // 假设当前从i往前个元素为M个，求maxL
            maxL = Math.max( maxL, A[i-M] - A[i-M-L] );
            // 假设当前从i往前个元素为L个，求maxM
            maxM = Math.max( maxM, A[i-L] - A[i-L-M] );

            // 情况1：当前i为连续M个元素的最后一个，则 ret = maxL + A[i] - A[i-M]
            // 情况2：当前i为连续L个元素的最后一个，则 ret = maxM + A[i] - A[i-L]
            // 求解 ret，情况1，情况2的最大值
            ret = Math.max( ret, Math.max(maxL + A[i] - A[i-M], maxM + A[i] - A[i-L]) );
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] A = new int[]{3,8,1,3,2,1,8,9,0};
        int L = 2;
        int M = 3;
        MaxSumTwoNoOverlap solution = new MaxSumTwoNoOverlap();
        System.out.println(solution.maxSumTwoNoOverlap(A, L, M));
    }
}
