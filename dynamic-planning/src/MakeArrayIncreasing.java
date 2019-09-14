/**
 * Created by Nelson on 2019/9/11.
 */

/**
 * 1187. Make Array Strictly Increasing
 * https://leetcode.com/problems/make-array-strictly-increasing/
 */

import java.util.*;
public class MakeArrayIncreasing {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        // 思路：动态规划
        // 参考LIS问题
        // 状态定义：dp[i]代表以arr1[i]为结尾，使得arr1[0...i]为严格上升序列的最小操作次数
        // 状态转移：dp[i] = dp[j] + change if arr1[j] < arr1[i]， 其中change = arr1[j+1...i]区间替换为上升序列的最小操作数

        int len = arr1.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 对arr2进行去重与排序处理
        Set<Integer> hashSet = new HashSet<>();
        for( Integer a : hashSet ) {
            hashSet.add(a);
        }

        int[] arr2Copy = new int[hashSet.size()];
        int k = 0;
        for( Integer val : hashSet ) {
            arr2Copy[k] = val;
        }

        Arrays.sort(arr2Copy);

        arr2 = arr2Copy;

        // 对arr1进行处理
        int[] arr1Copy = new int[len+1];
        arr1Copy[0] = Integer.MIN_VALUE;
        for( int i = 1; i <= len; i++ ) {
            arr1Copy[i] = arr1[i-1];
        }

        arr1 = arr1Copy;

        // dp
        for( int i = 1; i <= len; i++ ) {
            for( int j = i - 1; j >= 0; j-- ) {
                if( arr1[j] < arr1[i] && dp[j] != Integer.MAX_VALUE ) {
                    // 求解变化
                    int change = helper(arr1, arr2, j, i);
                    // 当有解时，更新结果
                    if( change >= 0 ) {
                        dp[i] = Math.min( dp[i], dp[j] + change );
                    }
                }
            }
        }

        return dp[len] == Integer.MAX_VALUE ? -1 : dp[len];

    }

    /**
     * 从arr2中挑选元素，对arr1[start+1, end]区间元素进行替换，求所需要的最小变化次数
     * @param arr1
     * @param arr2
     * @param start
     * @param end
     * @return
     */
    private int helper( int[] arr1, int[] arr2, int start, int end ) {
        // 如果end与start差一位，则不需要change，因为上游满足了arr1[end] > arr1[start]
        if( end == start + 1 )
            return 0;

        int minValue = arr1[start];
        int maxValue = arr1[end];

        // 在arr2中寻找比minValue大的值
        int idx = Arrays.binarySearch(arr2, minValue);
        // 判断是否找得到minValue
        if( idx < 0 ) {
            // 此时没找到，返回的idx为(-待插入位置-1)，待插入位置的元素就是比minValue大的最小元素
            idx = -idx - 1;
        } else {
            // 找到
            idx = idx + 1;
        }

        // 求需要变换的最大次数
        int maxChange = end - start - 1;  // 仅变换[start+1, end-1]元素
        int endi = idx + maxChange - 1;
        if( endi < arr2.length && arr2[endi] < maxValue ) {
            return maxChange;
        } else {
            return -1;
        }
    }

    public static void main( String[] args ) {
        // 测试用例
        int[] arr1 = new int[]{1, 5, 3, 6, 7};
        int[] arr2 = new int[]{4, 3, 1};
    }
}
