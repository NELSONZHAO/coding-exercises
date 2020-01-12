/**
 * Created by Nelson on 2019/9/21.
 */

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 239. Sliding Window Maximum
 */

import java.util.*;
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 使用堆维持k个元素
        int len = nums.length;
        // 求返回数组长度
        int size = len - k + 1;
        if( k == 1 ) {
            return nums;
        }

        int[] res = new int[size];

        // 构建最大堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if( o1[0] != o2[0] )
                    return o2[0] - o1[0];
                return o2[1] - o1[1];
            }
        });

        // 遍历nums前k个值，加入优先队列
        int i = 0;
        for( ; i < k; i++ ) {
            pq.offer(new int[]{nums[i], i});
        }

        int j = 0;
        res[j++] = pq.peek()[0];

        // 从 i = k 开始遍历
        while( i < len ) {
            int val = nums[i];
            // 比较关系
            if(  val >= pq.peek()[0] ) {
                res[j++] = val;
                pq.offer(new int[]{val, i});
            } else {
                int r = 0;
                // 取出最大值的索引
                int idx = pq.peek()[1];
                // 保证不会被移动走
                if( idx > i - k ) {
                    r = pq.peek()[0];
                } else {
                    // 不断弹出最大值，直到当前最大值不越界
                    while( pq.peek()[1] <= i - k ) {
                        pq.poll();
                    }
                    r = Math.max( pq.peek()[0], val );
                }

                pq.offer(new int[]{val, i});
                res[j++] = r;
            }

            i++;
        }

        return res;
    }

    public static void main( String[] args ) {
        // 测试用例
        int[] nums = new int[]{9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        SlidingWindowMaximum solution = new SlidingWindowMaximum();
        int[] res = solution.maxSlidingWindow(nums, k);
        for( int i = 0; i < res.length; i++ ) {
            System.out.println(res[i]);
        }
    }
}
