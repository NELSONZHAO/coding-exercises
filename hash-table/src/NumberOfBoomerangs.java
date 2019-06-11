/**
 * Created by Nelson on 2019/6/11.
 */

/**
 * 447. Number of Boomerangs
 * https://leetcode.com/problems/number-of-boomerangs/
 */

import java.nio.channels.Pipe;
import java.util.*;
public class NumberOfBoomerangs {

//    public int numberOfBoomerangs(int[][] points) {
//        // 思路：查找表
//        // 使用O(n2)时间复杂度遍历所有元素，计算两两点的距离
//        // 将距离相等的点放入同一个key（key为点之间的距离）中
//        // 根据组合问题求解
//        // 时间复杂度：O(n2)
//        // 空进复杂度：O(n)
//
//        int ret = 0;
//
//        if( points.length < 3 )
//            return ret;
//
//        // O(n2)遍历，构建查找表
//        for( int i = 0; i < points.length; i++ ) {
//            // 创建hash-table
//            // key为其余点到当前点的距离
//            // value为对应距离的点数量
//            Map<Integer, Integer> hashMap = new HashMap<>();
//            int[] point = points[i];
//
//            for( int j = 0; j < points.length; j++ ) {
//                if( j == i )
//                    continue;
//
//                // 计算距离
//                int dist = (int)Math.pow(point[0] - points[j][0], 2) + (int)Math.pow(point[1] - points[j][1], 2);
//
//                hashMap.put(dist, hashMap.getOrDefault(dist, 0) + 1);
//            }
//
//            // 计算结果
//            for( Integer key : hashMap.keySet() ) {
//                int cnt = hashMap.get(key);
//                ret += cnt * ( cnt - 1 );
//            }
//        }
//
//        return ret;
//    }

    public int numberOfBoomerangs(int[][] points) {
        // 优化点：避免重复创建hashMap
        // 避免重复扫描hashMap
        // 在构造hashMap过程中记录结果

        int ret = 0;
        if( points.length < 3 )
            return ret;

        // 创建一次hashMap，后续clear
        Map<Integer, Integer> hashMap = new HashMap<>();

        for( int i = 0; i < points.length; i++ ) {

            for( int j = 0; j < points.length; j++ ) {
                int dist = (int)Math.pow(points[i][0] - points[j][0], 2) + (int)Math.pow(points[i][1] - points[j][1], 2);

                // 判断hashMap中是否已经存在dist
                // 当存在时，意味着对应与points[i]的距离为dist的点有n个（n>=1，至少已经存在1个），而此时又新来了一个
                // 由于组合中考虑顺序，因此此时需要从n个里面选出1个和这个新的来组合，有n个选择
                // 其次还要考虑选出的这个和新来这个点的顺序，即n*2
                if( hashMap.containsKey(dist) ) {
                    ret += 2 * hashMap.get(dist);
                }

                hashMap.put(dist, hashMap.getOrDefault(dist, 0) + 1);
            }

            hashMap.clear();
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        NumberOfBoomerangs solution = new NumberOfBoomerangs();
        System.out.println(solution.numberOfBoomerangs(points));
    }
}
