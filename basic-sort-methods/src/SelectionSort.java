/**
 * Created by Nelson on 2019/8/5.
 */

/**
 * 选择排序
 * 时间复杂度：O(n2)
 * 空间复杂度：O(1)
 */
public class SelectionSort {

    public void selectionSort(int[] nums) {
        // 每次从nums[i+1...n-1]选择一个最小的数和nums[i]交换
        int n = nums.length;
        if( n <= 1 )
            return;

        for( int i = 0; i < n; i++ ) {
            int minIndex = i;
            for( int j = i + 1; j < n; j++ ) {
                if( nums[j] < nums[minIndex] )
                    minIndex = j;
            }

            // 交换i和minIndex
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
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

        SelectionSort solution = new SelectionSort();
        solution.selectionSort(nums);
        System.out.print("After Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}
