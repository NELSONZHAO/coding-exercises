/**
 * Created by Nelson on 2019/9/11.
 */
public class MaximumSubarraySumwithOneDeletion {
    public int maximumSum(int[] arr) {
        // 思路：如果先不考虑删除问题，寻找连续最大和区间
        int len = arr.length;

        int res = Integer.MIN_VALUE;
        // 矩阵sum[i][j]存储[i...j]区间的连续和
        // 矩阵minValue[i][j]存储[i...j]区间的最小值
        int[][] sum = new int[len][len];
        int[][] minValue = new int[len][len];

        // 求sum和minValue
        // 初始化sum和minValue
        sum[0][0] = arr[0];
        minValue[0][0] = arr[0];
        for( int j = 1; j < len; j++ ) {
            // 求解sum
            sum[0][j] = sum[0][j-1] + arr[j];
            // 求解minValue
            minValue[0][j] = Math.min( minValue[0][j-1], arr[j] );
        }
        // 填充sum和minValue
        for( int i = 1; i < len; i++ ) {
            sum[i][i] = arr[i];
            minValue[i][i] = arr[i];
            for( int j = i+1; j < len; j++ ) {
                sum[i][j] = sum[i][j-1] + arr[j];
                minValue[i][j] = Math.min(minValue[i][j-1], arr[j] );

                // 比较大小
                res = Math.max( res, Math.max( sum[i][j], sum[i][j] - minValue[i][j] ) );
            }
        }


        return res;
    }
//        // sum代表从[l...i-1]的累加和
//        int sum = arr[0];
//        // minValue代表从[0...i-1]区间的最小值
//        int minValue = arr[0];
//
//        // res存储结果
//        int res = arr[0];
//
//        for( int i = 1; i < len; i++ ) {
//            // 先更新[l...i-1]区间最小值
//
//            // 如果前面连续累加和 < 0，则有两种选择
//            // 1.当前i开始重新计算子区间的和
//            // 2.删除[l...i-1]区间的最小值计算
//            if( sum < 0 ) {
//                // 1. 删除[l...i-1]区间的最小值后观察是否还小于0
//                if( sum - minValue < 0 ) {
//                    sum = arr[i];
//                    // 更新最小值
//                    minValue = arr[i];
//                } else {
//                    sum = sum - minValue + arr[i];
//                    minValue = Math.min( minValue, arr[i] );
//                }
//            } else {
//                sum += arr[i];
//                // 比较删除最小值后的大小
//                if( minValue < 0 ) {
//                    sum += -minValue;
//                }
//                // 更新最小值
//                minValue = Math.min( minValue, arr[i] );
//            }
//
//            res = Math.max( res, sum );
//        }

//        return res;
//    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, -2, 0, 3};
        MaximumSubarraySumwithOneDeletion solution = new MaximumSubarraySumwithOneDeletion();
        int res = solution.maximumSum(arr);
        System.out.println(res);
    }
}
