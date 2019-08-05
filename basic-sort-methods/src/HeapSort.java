/**
 * Created by Nelson on 2019/8/5.
 */

/**
 * 堆排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
public class HeapSort {

    public void heapSort(int[] nums) {

        int n = nums.length;

        // 对数组进行堆化，当索引从0开始时，堆中最后一个非叶子结点的索引为(n-1)/2
        for( int i = (n-1)/2; i >= 0; i-- ) {
            __shiftDown(nums, n, i);
        }

        // 堆排序：最大堆
        // 基本思路：交换堆顶元素和最尾部元素
        // 尾部有序，头部元素重新shiftDown
        for( int i = n - 1; i > 0; i-- ) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            __shiftDown(nums, i, 0);
        }

        return;
    }

    /**
     * 对容量为n的数组nums中索引为k的元素进行shiftDown操作
     * @param nums
     * @param n
     * @param k
     */
    private void __shiftDown(int[] nums, int n, int k) {
        while( 2 * k + 1 < n ) {

            int j = 2 * k + 1;
            if( j + 1 < n && nums[j+1] > nums[j] ) {
                j += 1;
            }

            // 此时不需要交换
            if( nums[k] > nums[j] )
                break;

            // 此时j为待交换结点
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;

            k = j;
        }
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{4, 3, 6, 5, 1, 2, 7};
        System.out.print("Before Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        HeapSort solution = new HeapSort();
        solution.heapSort(nums);
        System.out.print("After Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}
