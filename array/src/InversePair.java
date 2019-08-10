/**
 * Created by Nelson on 2019/8/5.
 */

/**
 * 求解一个数组中的逆序对
 * 逆序对定义：对于数组中的索引i < j，且nums[i] > nums[j]，则为一个逆序对
 * 例如[1,3,2,4,5]中，对于i=1时，nums[1] = 3,i=2时，nums[2] = 2，此时i<j,但是nums[i] > nums[j]
 */
public class InversePair {

    public int inversePair(int [] array) {
        // 思路：归并排序可以实现
        int n = array.length;
        if( n <= 1 )
            return 0;

        long ret = 0;

        // 归并排序
        // 第一层遍历：选择归并窗口数
        for( int sz = 1; sz <= n; sz += sz )  {
            // 第二层遍历：对选定的两部分进行归并
            for( int i = 0; i + sz < n; i += sz + sz ) {
                ret += __merge(array, i, i+sz-1, i+sz+sz-1 < n-1? i+sz+sz-1 : n-1 );
            }
        }

        return (int)ret;
    }

    /**
     * 对给定arr[l...mid]和arr[mid+1...r]区间的元素进行归并
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private long __merge(int[] arr, int l, int mid, int r) {
        // 对arr[l...mid], [mid+1...r]数组进行归并并统计逆序对
        // 定义辅助空间
        int[] aux = new int[r-l+1];
        for( int i = l; i <= r; i++ ) {
            aux[i-l] = arr[i];
        }

        // 初始化计数器
        long cnt = 0;

        // 初始化指针
        int i = l;
        int j = mid+1;

        for( int k = l; k <= r; k++ ) {
            // 检查数组越界
            if( i > mid ) {
                arr[k] = aux[j-l];
                j++;
            } else if( j > r ) {
                arr[k] = aux[i-l];
                i++;
            } else if( aux[i-l] <= aux[j-l] ) {
                arr[k] = aux[i-l];
                i++;
            } else {
                arr[k] = aux[j-l];
                j++;
                // 更新逆序对数
                cnt += (long)mid-i+1;
//                // 更新重要逆序对
//                int p = i;
//                while( p <= mid && aux[p-l] <= 2 * aux[j-l] ) {
//                    p++;
//                }
//
//                cnt += (long)mid-p+1;
            }
        }

        return cnt;
    }

    public static void main( String[] args ) {
        // 测试用例
        int[] nums = new int[]{1, 3, 2, 3, 1};
        InversePair solution = new InversePair();
        System.out.println(solution.inversePair(nums));
    }
}
