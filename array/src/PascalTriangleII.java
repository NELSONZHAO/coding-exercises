/**
 * Created by Nelson on 2019/4/2.
 */

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 */

import java.util.*;
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        // 时间复杂度：O(n2)
        // 空间复杂度：O(rowIndex)

        if( rowIndex < 0 )
            throw new IllegalArgumentException();

        // 初始化返回结果
        List<Integer> ret = new ArrayList<>();
        ret.add(1);

        // 从index=1开始遍历，因为index=0已经被初始化
        for( int i = 1; i <= rowIndex; i++ ) {
            // 从最后一列开始向前
            ret.add(1);
            for( int j = i - 1; j > 0; j-- ) {
                int val = ret.get(j) + ret.get(j-1);
                ret.set(j, val);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int rowIndex = 4;
        PascalTriangleII solution = new PascalTriangleII();
        List<Integer> ret = solution.getRow(rowIndex);

        for( int i = 0; i < ret.size(); i++ )
            System.out.println(ret.get(i));
    }
}
