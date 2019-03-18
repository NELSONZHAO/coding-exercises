/**
 * Created by Nelson on 2019/3/17.
 */

/**
 * 120. Triangle
 * https://leetcode.com/problems/triangle/
 */

import java.util.*;

public class Triangle {

    public int minimumTotal(List<List<Integer>> Triangle) {
        // 思路：动态规划

        int n = Triangle.size();

        // 初始化数组
        // memo[i]代表某一行第从根到该i元素的最短路径和
        int[] memo = new int[n];
        // 用最后一行元素初始化数组
        for( int i = 0; i < n; i++ )
            memo[i] = Triangle.get(n-1).get(i);

        // 从倒数第二行开始遍历
        for( int i = n-2; i >= 0; i-- ) {
            // 对于每行的每个元素遍历
            for( int j = 0; j <= i; j++ ) {
                memo[j] = Triangle.get(i).get(j) + Math.min( memo[j], memo[j+1] );
            }
        }

        return memo[0];
    }

    public static void main(String[] args) {
        // 测试用例
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(2);
        List<Integer> second = new ArrayList<>();
        second.add(3);
        second.add(4);
        List<Integer> third = new ArrayList<>();
        third.add(6);
        third.add(5);
        third.add(7);
        List<Integer> fourth = new ArrayList<>();
        fourth.add(4);
        fourth.add(1);
        fourth.add(8);
        fourth.add(3);
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);

        Triangle solution = new Triangle();
        System.out.println(solution.minimumTotal(list));
    }
}
