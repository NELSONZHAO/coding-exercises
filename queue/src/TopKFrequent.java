/**
 * Created by Nelson on 2019/7/15.
 */

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

import java.util.*;
public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // TopK问题都是优先队列问题
        // 思路：扫描一遍数组统计每个元素的特征{n: counts}
        // 构造(counts, n)对入队列（最小堆）
        List<Integer> res = new ArrayList<>();
        if( nums.length == 0 || k <= 0 )
            return res;

        // 统计元素出现频率
        Map<Integer, Integer> hashMap = new HashMap<>();
        for( int n : nums ) {
            hashMap.put( n, hashMap.getOrDefault(n, 0) + 1 );
        }

        // 判断k与nums的关系

        boolean reverse = k > hashMap.size() / 2 && k != hashMap.size();
        // 如果k < hashMap.size()/2，则构造最小堆，直接解问题
        if( !reverse ) {
            // 队列中的元素为int[], 其中int[0]是freq, int[1]是对应元素
            Queue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if( o1[0] != o2[0] )
                        return o1[0] - o2[0];
                    return o1[1] - o2[1];
                }
            });

            // 入队元素
            for( int key : hashMap.keySet() ) {
                int value = hashMap.get(key);

                if( pq.size() == k ) {
                    if( value > pq.peek()[0] ) {
                        pq.poll();
                        pq.offer( new int[]{value, key} );
                    }
                } else {
                    pq.offer( new int[]{value, key} );
                }
            }

            // 遍历求解
            while( !pq.isEmpty() ) {
                res.add( pq.poll()[1] );
            }

            return res;
        }
        // 如果k > hashMap.size()/2，构造最大堆，反向解问题
        else {
            int len = hashMap.size();
            // 最大堆
            Queue<int[]> pq = new PriorityQueue<>(len-k, new Comparator<int[]>(){
                @Override
                public int compare( int[] o1, int[] o2 ) {
                    if( o1[0] != o2[0] )
                        return o2[0] - o1[0];
                    return o2[1] - o1[1];
                }
            });

            for( int key : hashMap.keySet() ) {
                int value = hashMap.get(key);

                if( pq.size() == len-k ) {
                    if( value < pq.peek()[0] ) {
                        pq.poll();
                        pq.offer( new int[]{value, key} );
                    }
                } else {
                    pq.offer( new int[]{value, key});
                }
            }

            // 遍历
            Set<Integer> drop = new HashSet<>();
            while( !pq.isEmpty() ) {
                drop.add(pq.poll()[1]);
            }

            // 遍历
            for( int key : hashMap.keySet() ) {
                if( !drop.contains(key) )
                    res.add(key);
            }

            return res;
        }
    }


    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        TopKFrequent solution = new TopKFrequent();
        List<Integer> res = solution.topKFrequent(nums, k);

        for( int n : res ) {
            System.out.println(n);
        }
    }
}
