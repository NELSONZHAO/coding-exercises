/**
 * Created by Nelson on 2019/3/31.
 */

import java.util.*;

/**
 *
 * https://leetcode.com/problems/binary-subarrays-with-sum/solution/
 */
public class NumSubarraysWithSum {

//    public int numSubarraysWithSum(int[] A, int S) {
//        // 思路1：查找表，令agg[i] = A[0]+A[1]+...+A[i-1];
//        // 则找到agg[j]-agg[i] == S有多少个即可
//        // 时间复杂度：O(n)
//        // 空间复杂度：O(n)
//
//        int n = A.length;
//        if( n == 0 )
//            return 0;
//
//        // 返回结果
//        int ret = 0;
//
//        int[] agg = new int[n+1];
//        for( int i = 0; i < n; i++ ) {
//            agg[i+1] = agg[i] + A[i];
//        }
//
//        // 查找表
//        // 要找到 agg[j] - agg[i] = S 有多少对
//        // 等价于 agg[j] = agg[i] + S 有多少个
//        // 由于数组里面只有0-1，因此agg[j]>=agg[i]，所以才可以采用O(n)时间复杂度去遍历求解
//        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//        for( int a : agg ) {
//            ret += hashMap.getOrDefault(a, 0);
//            hashMap.put(a+S, hashMap.getOrDefault(a+S, 0) + 1);
//        }
//
//        return ret;
//    }
//

    public int numSubarraysWithSum(int[] A, int S) {
        // 思路2：三个指针
        // 给定索引j与i，A[i, j]==S
        // 由于A[i]可能为0，则对于A[i, j]==S的i来说，变成了一个窗口，即iLow, iHigh
        // 即从[iLow, iHigh]的i，都满足A[i, j]==S，此时返回iHigh -iLow + 1即可
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)

        int n = A.length;
        if( n == 0 )
            return 0;

        // 返回结果
        int ret = 0;

        // 设置指针
        int iLow = 0; // iLow代表满足 A[i, j] <= S 的最小索引
        int iHigh = 0; // iHigh代表满足 A[i, j] <= S 的最大索引
        int sumLow = 0; // A[ilow, j]的和
        int sumHigh = 0; // A[iHigh, j]的和

        // 遍历每个索引j
        for( int j = 0; j < n; j++ ) {
            // 找到iLow
            sumLow += A[j];
            while( iLow < j && sumLow > S )
                sumLow -= A[iLow++];

            // 找到iHigh
            sumHigh += A[j];
            while( iHigh < j && (sumHigh > S || sumHigh == S && A[iHigh] == 0 ) )
                sumHigh -= A[iHigh++];

            // sumLow满足条件
            if( sumLow == S )
                ret += iHigh - iLow + 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] A = new int[]{0, 1, 0, 1, 0, 1};
        int S = 2;
        NumSubarraysWithSum solution = new NumSubarraysWithSum();
        System.out.println(solution.numSubarraysWithSum(A, S));
    }
}
