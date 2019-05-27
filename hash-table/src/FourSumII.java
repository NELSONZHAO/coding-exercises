/**
 * Created by Nelson on 2019/5/27.
 */

import java.util.HashMap;

/**
 * 454. 4Sum II
 * https://leetcode.com/problems/4sum-ii/
 */

import java.util.*;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 思路：查找表
        // 构造一个查找表，存储A[i] + B[j]和的个数
        // 用n2时间复杂度去遍历C和D

        int len = A.length;

        int ret = 0;

        // 构建hash-table，存储 A[i] + B[j] : sum 对
        Map<Integer, Integer> hashMap = new HashMap<>();
        // 双重循环
        for( int i = 0; i < len; i++ ) {
            for( int j = 0; j < len; j++ ) {
                int sum = A[i] + B[j];
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
            }
        }

        // 双重循环遍历C和D，查找-C[i]-D[j]
        for( int i = 0; i < len; i++ ) {
            for( int j = 0; j < len; j++ ) {
                int target = - C[i] - D[j];
                if( hashMap.containsKey(target) ) {
                    ret += hashMap.get(target);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};

        FourSumII solution = new FourSumII();
        int ret = solution.fourSumCount(A, B, C, D);

        System.out.println(ret);
    }
}
