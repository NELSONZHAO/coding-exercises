/**
 * Created by Nelson on 2019/5/23.
 */

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinDominoRotations {

    public int minDominoRotations( int[] A, int[] B ) {
        if( A.length != B.length )
            return -1;

        int len = A.length;

        // 构建hash-table
        int[] setA = new int[7];
        int[] setB = new int[7];
        int same = 0;  // 记录A和B相同元素

        for( int i = 0; i < len; i++ ) {
            setA[A[i]]++;
            setB[B[i]]++;

            if( A[i] == B[i] )
                same++;
        }

        // 遍历hash-table，返回结果
        for( int i = 1; i < 7; i++ ) {
            if( setA[i] + setB[i] - same >= len ) {
                return Math.min(setA[i], setB[i]) - same;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] A = new int[]{2,1,2,4,2,2};
        int[] B = new int[]{5,2,6,2,3,2};

        MinDominoRotations solution = new MinDominoRotations();
        int ret = solution.minDominoRotations(A, B);

        System.out.println(ret);
    }
}
