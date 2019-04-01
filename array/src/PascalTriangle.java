/**
 * Created by Nelson on 2019/4/1.
 */

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */

import java.util.*;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        // 思路：自上而下的求解
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if( numRows == 0 )
            return ret;

        // 初始化第一行
        List<Integer> fstRow = new ArrayList<>();
        fstRow.add(1);
        ret.add(fstRow);

        // 循环求解
        for( int i = 1; i < numRows; i++ ) {
            // 存储每行的元素
            List<Integer> subList = new ArrayList<>();
            subList.add(1); // 每行第一个元素都是1

            // 从第二列开始
            for( int j = 1; j < i; j++ ) {
                subList.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
            }

            // 最后一个元素是1
            subList.add(1);
            // 添加当前行
            ret.add(subList);
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int numRows = 7;
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> result = solution.generate(numRows);

        for( int i = 0; i < result.size(); i++ ) {
            for( int j = 0; j <= i; j++ ) {
                System.out.print(result.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }
}
