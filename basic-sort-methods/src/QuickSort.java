/**
 * Created by Nelson on 2019/8/5.
 */

/**
 * 三路快排
 * 维持三个指针：lt, gt, i
 * 其中[0...lt]区间元素<anchor
 * [lt+1, i)区间元素=anchor
 * [gt...n-1]区间元素>anchor
 *
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 快速排序在近乎有序的情况下会退化到O(n2)
 */
public class QuickSort {

    public void quickSort3Ways(int[] nums) {
        // 步骤：1.选择锚定点
        //      2.对左右两部分QuickSort
        int n = nums.length;
        if( n <= 1 )
            return;

        // 排序
        __quickSort(nums, 0, n-1);
        return;
    }

    /**
     * 对nums[l...r]区间内元素进行quickSort
     * @param nums
     * @param l
     * @param r
     */
    private void __quickSort(int[] nums, int l, int r) {
        // 递归结束条件
        if( l > r )
            return;

        // 递归过程
        // 寻找Partition
        int anchor = nums[l];

        int lt = l;
        int gt = r + 1;
        int i = l + 1;

        while( i < gt ) {
            // 判断当前元素
            int e = nums[i];
            if( e < anchor ) {
                // 此时和lt+1交换位置
                nums[i] = nums[lt+1];
                nums[lt+1] = e;
                // 更新索引
                lt++;
                i++;
            } else if( e == anchor ) {
                i++;
            } else {
                // 此时交换gt-1和i的位置
                nums[i] = nums[gt-1];
                nums[gt-1] = e;
                // 更新索引
                gt--;
            }
        }

        // 此时对于锚定点进行交换
        nums[l] = nums[lt];
        nums[lt] = anchor;

        // 进行递归
        __quickSort(nums, l, lt-1);
        __quickSort(nums, gt, r);
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{4, 3, 6, 5, 1, 2, 7};
        System.out.print("Before Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        QuickSort solution = new QuickSort();
        solution.quickSort3Ways(nums);
        System.out.print("After Sort: ");
        for( int i = 0; i < nums.length; i++ ) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}
