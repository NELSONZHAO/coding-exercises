/**
 * Created by Nelson on 2019/4/24.
 */

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 思路：归并排序中归并的过程
        // 时间复杂度：O(m+n)
        // 空间复杂度：O(m+n)

        if( n == 0 )
            return;

        // 开辟辅助空间
        int[] aux = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            aux[i] = i < m ? nums1[i] : nums2[i - m];
        }

        // 定义两个指针
        int p = 0;  // p指向aux中nums1的元素
        int q = m;  // q指向aux中nums2的元素

        for (int i = 0; i < m + n; i++) {
            // 当nums1被遍历完时
            if (p > m - 1) {
                nums1[i] = aux[q++];
            } else if (q > m + n - 1) {
                nums1[i] = aux[p++];
            } else if (aux[p] <= aux[q]) {
                nums1[i] = aux[p++];
            } else {
                nums1[i] = aux[q++];
            }

        }

        return;
    }
}
