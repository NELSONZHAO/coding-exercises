/**
 * Created by Nelson on 2019/9/14.
 */

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/
 */

import java.util.*;
public class PermutationSequence {

    public String permutationSequence(int n, int k) {
        // 思路：缩小搜索范围
        // 构建从1-n不同数字范围的排列个数
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for( int i = 1; i <= n; i++ ) {
            factorial[i] = factorial[i-1] * i;
        }

        // 构建结果字符串
        StringBuilder sb = new StringBuilder();

        // 构建元素集合
        List<Integer> elements = new ArrayList<>();
        for( int i = 1; i <= n; i++ ) {
            elements.add(i);
        }

        // 从第一个数字开始确定结果
        // 首先判断k和排列个数的关系
        // k <= n!

        for( int i = 1; i <= n; i++ ) {
            // 判断(n-i)的阶乘可以组成多少排列数
            // k-1代表索引号，缩小搜索范围
            int index = (k-1) / factorial[n-i];
            sb.append(String.valueOf(elements.get(index)));
            // 移除index位置的元素（这里需要O(n)时间复杂度）
            elements.remove(index);
            // 更新k
            k = k - index * factorial[n-i];
        }

        return new String(sb);
    }
}
