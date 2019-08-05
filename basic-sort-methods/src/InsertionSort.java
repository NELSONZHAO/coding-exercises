/**
 * Created by Nelson on 2019/8/5.
 */

/**
 * 插入排序
 * 时间复杂度：O(n2)，但可以提前结束，对于近乎有序的数组来说，插入排序的时间复杂度接近O(n)
 * 空间复杂度：O(1)
 * 稳定排序
 */
public class InsertionSort {

    public void insertionSort(int[] nums) {
        int n = nums.length;
        if( n <= 1 )
            return;

        // 对于当前索引i位置的元素，将其与前[0...i-1]个元素进行比较，选择对应位置插入
        for( int i = 1; i < n; i++ ) {
            // 记录当前i的位置为待插入位置
            int j;
            int e = nums[i];
            for( j = i; j > 0; j-- ) {
                if( e < nums[j-1] ) {
                    nums[j] = nums[j-1];
                } else {
                    break;
                }
            }

            // 交换位置
            nums[j] = e;
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

        InsertionSort solution = new InsertionSort();
        solution.insertionSort(nums);
        System.out.print("After Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}
