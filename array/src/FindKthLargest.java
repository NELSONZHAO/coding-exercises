/**
 * Created by Nelson on 2019/4/25.
 */

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

import java.util.PriorityQueue;
public class FindKthLargest {

    public int findKthLargest1(int[] nums, int k) {
        // 思路：使用快排partition的思路，anchor的位置就是最终的索引位置
        // 时间复杂度：O(n)
        // 空间复杂度：O(logn)

        int n = nums.length;
        if( n == 0 )
            return 0;

        return helper(nums, 0, n-1, k);
    }

    private int helper(int[] nums, int l, int r, int k) {
        // 函数功能：在nums[l...r]区间内，找第k大的数
        // 递归函数

        // 选定anchor
        int anchor = nums[l];

        // 双路快排，把anchor放在合适的位置
        // 使得[l+1...i) > anchor, (j...r] < anchor
        int i = l + 1;
        int j = r;

        while( true ) {
            while( i <= r && nums[i] > anchor ) {
                i++;
            }

            while( j >= l && nums[j] < anchor ) {
                j--;
            }

            if( i > j ) {
                break;
            }

            // 交换nums[i]和nums[j];
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

        // 交换anchor与比anchor大的最后一个数(nums[j])
        nums[l] = nums[j];
        nums[j] = anchor;

        // 此时anchor所在的位置就是其最终的位置，其索引为j，代表anchor为第j+1大元素
        // 如果k - 1 > j，在nums[j+1...r]找第k-j大数
        if( k - 1 > j ) {
            return helper(nums, j+1, r, k);
        } else if( k - 1 < j ) { // 否则在nums[l...j-1]找第k大数
            return helper(nums, l, j-1, k);
        } else {
            return anchor;
        }
    }

    // 解法2
    public int findKthLargest2(int[] nums, int k) {
        // 思路：建立堆
        // 时间复杂度：O(nlogk)
        int len = nums.length;
        if( len == 0 )
            return 0;

        // 最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 遍历所有元素，入堆
        for( int i = 0; i < len; i++ ) {
            // offer元素
            pq.offer(nums[i]);

            // 当堆中元素超过k时，由于是最小堆，说明顶部元素最小，而此时存在k个数都比它大
            // 由于我们要找第k大元素，所以堆顶元素一定不满足我们的要求，就不停弹出
            if( pq.size() > k )
                pq.poll();
        }

        // 此时堆顶元素为第k大元素
        return pq.poll();
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{4, 3, 1, 2, 7, 5, 9};
        int k = 3;

        FindKthLargest solution = new FindKthLargest();
        System.out.println(solution.findKthLargest1(nums, k));
        System.out.println(solution.findKthLargest2(nums, k));
    }
}
