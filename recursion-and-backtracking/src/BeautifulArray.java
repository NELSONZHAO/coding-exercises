/**
 * Created by Nelson on 2019/4/1.
 */

/**
 * 932. Beautiful Array
 * https://leetcode.com/problems/beautiful-array/
 */
public class BeautifulArray {

    public int[] beautifulArray(int N) {
        // 思路：递归
        // A是由1, 2, 3, ..., N组成的数组
        // 根据题意，要满足任意 i < k < j 使得 2*A[k] != A[i] + A[j]
        // 由于2*A[k]为偶数，则可以推导出 A[i] + A[j] 必须为奇数
        // 因此对于给定数A[k]，让奇数全部放置在A[k]左侧，偶数全部放在A[k]右侧即可（或偶数在左侧，奇数在右侧）
        // 且要满足A[k]左右两侧是beautiful的


        // 递归终止条件
        if( N == 1 )
            return new int[]{1};

        // 递归过程
        int[] ret = new int[N];

        // 左边
        int[] odd = beautifulArray((N+1)/2);
        // 右边
        int[] even = beautifulArray(N/2);

        int i = 0;
        // 奇数部分
        for( ; i < (N+1)/2; i++ ) {
            ret[i] = 2 * odd[i] - 1;  // 左边都是奇数
        }
        // 偶数部分
        for( ; i < N; i++ ) {
            ret[i] = 2 * even[i-(N+1)/2];  // 右边都是偶数
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int N = 7;
        BeautifulArray solution = new BeautifulArray();
        int[] result = solution.beautifulArray(N);
        for( int r : result ) {
            System.out.print(r + " ");
        }
    }
}
