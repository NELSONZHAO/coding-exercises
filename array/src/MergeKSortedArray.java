/**
 * Created by Nelson on 2019/7/15.
 */

/**
 * 参考23. Merge k Sorted Lists
 */

import java.util.*;
public class MergeKSortedArray {

    public int[] mergeKSortedArray(int[][] arr) {
        // 思路：优先队列
        // 每个数组用一个队列存储
        int k = arr.length;
        if( k == 0 )
            return new int[]{};

        Queue<Queue<Integer>> pq = new PriorityQueue<>(k, new Comparator<Queue<Integer>>() {
            @Override
            public int compare(Queue<Integer> o1, Queue<Integer> o2) {
                return o1.peek() - o2.peek();
            }
        });

        // k个数组入队
        for( int[] a : arr ) {

            if( a.length > 0 ) {
                Queue<Integer> q = new LinkedList<>();
                for (int n : a) {
                    q.offer(n);
                }
                pq.offer(q);
            }

        }

        // 进行归并
        List<Integer> res = new ArrayList<>();
        while( !pq.isEmpty() ) {
            // 队首元素
            Queue<Integer> q = pq.poll();
            res.add( q.poll() );

            if( !q.isEmpty() ) {
                pq.offer(q);
            }
        }

        int[] ret = new int[res.size()];
        for( int i = 0; i < res.size(); i++ ) {
            ret[i] = res.get(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] arr = new int[][]{{1, 2, 3, 4}, {2, 3, 3, 4}, {1, 3, 4}, {4, 5, 6}};
        MergeKSortedArray solution = new MergeKSortedArray();
        int[] res = solution.mergeKSortedArray(arr);

        for( int n : res ) {
            System.out.println(n);
        }
    }
}
