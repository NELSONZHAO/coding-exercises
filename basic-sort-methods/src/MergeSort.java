/**
 * Created by Nelson on 2019/8/5.
 */

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)开辟辅助空间
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        // 归并排序
        int n = nums.length;
        if( n <= 1 )
            return;

        __mergeSort(nums, 0, n-1);
    }

    private void __mergeSort(int[] nums, int l, int r) {
        // 对nums[l...r]区间元素进行mergeSort

        // 递归函数
        if( l >= r )
            return;

        // 选择mid
        int mid = l + ( r - l ) / 2;
        __mergeSort(nums, l, mid);
        __mergeSort(nums, mid+1, r);

        if( nums[mid] > nums[mid+1] )
            __merge(nums, l, mid, r);
    }

    private void __merge(int[] nums, int l, int mid, int r) {
        // 对nums[l...mid]和nums[mid+1,r]区间的元素进行merge
        // 构造辅助空间
        int[] aux = new int[r-l+1];
        // 赋值
        for( int i = l; i <= r; i++ ) {
            aux[i-l] = nums[i];
        }

        // 进行归并
        int p = l;
        int q = mid + 1;

        // 遍历数组
        // k为当前待放置的空槽
        for( int k = l; k <= r; k++ ) {
            // 左边子数组遍历完
            if( p > mid ) {
                nums[k] = aux[q-l];
                q++;
            } else if( q > r ) {
                nums[k] = aux[p-l];
                p++;
            } else if( aux[p-l] < aux[q-l] ) {
                nums[k] = aux[p-l];
                p++;
            } else {
                nums[k] = aux[q-l];
                q++;
            }
        }

        return;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{4, 3, 6, 5, 1, 2, 7};
        System.out.print("Before Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        MergeSort solution = new MergeSort();
        solution.mergeSort(nums);
        System.out.print("After Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}
