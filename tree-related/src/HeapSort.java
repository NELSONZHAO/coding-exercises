/**
 * Created by Nelson on 2019/7/22.
 */

/**
 * 堆排序
 */
public class HeapSort {

    public void heapSort( int[] arr ) {
        // 思路：对非叶子结点进行堆化，进而不断交换头部结点和尾部结点，再反复堆化
        // 标记从0开始
        int n = arr.length;
        // 最后一个非叶子结点编号为(n-1)/2，对每个非叶子结点shiftDown进行堆化
        for( int i = (n-1)/2; i >= 0; i-- ) {
            __shiftDown(arr, n, i);
        }

        // 遍历所有结点，不断交换和维护堆
        for( int i = n-1; i > 0; i-- ) {
            // 交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 对头部新的元素进行shiftDown
            __shiftDown(arr, i, 0);
        }
    }

    /**
     * 对大小为n的堆的第k个元素进行shiftDown
     * @param arr
     * @param n
     * @param k
     */
    private void __shiftDown( int[] arr, int n, int k ) {

        // 当有孩子元素时再shiftDown
        while( 2 * k + 1 < n ) {
            int j = 2 * k + 1;

            if( j + 1 < n && arr[j+1] > arr[j] ) {
                j += 1;
            }

            // 此时判断待交换的孩子节点值
            if( arr[k] >= arr[j] )
                break;

            // 交换
            int temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;

            k = j;
        }
    }

    public static void main( String[] args ) {
        // 测试用例
        int[] arr = new int[]{6, 4, 7, 5, 3, 1, 2};
        HeapSort solution = new HeapSort();
        solution.heapSort(arr);
        for( int i = 0; i < arr.length; i++ ) {
            System.out.println(arr[i]);
        }
    }
}
