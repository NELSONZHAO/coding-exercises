/**
 * Created by Nelson on 2019/4/21.
 */

/**
 * 1029. Two City Scheduling
 * https://leetcode.com/problems/two-city-scheduling/
 */

import java.util.*;

public class TwoCitySchedCost {

    public int twoCitySchedCost(int[][] costs) {
        // 思路：贪心算法
        // 1.先按照成本最低原则，将costs分配到成本较低的一方
        // 2.如果出现成本一样的，放入少的一方
        // 3.从多的里面取出成本差异最小的costs放入少的一方，直到两方人数相等

        int m = costs.length;
        if( m == 0 )
            return 0;

        // 初始化cityA和cityB的costs数组
        List<int[]> costsA = new ArrayList<>();
        List<int[]> costsB = new ArrayList<>();
        // 记录成本相等的人
        List<int[]> costsEqual = new ArrayList<>();

        // 遍历costs，按照成本最小分配
        for( int i = 0; i < m; i++ ) {
            if( costs[i][0] < costs[i][1] ) {
                costsA.add(costs[i]);
            } else if ( costs[i][0] > costs[i][1] ) {
                costsB.add(costs[i]);
            } else {
                costsEqual.add(costs[i]);
            }
        }

        // 把成本相等的放入少的一方
        if( costsA.size() > costsB.size() )
            costsB.addAll(costsEqual);
        else
            costsA.addAll(costsEqual);

        // 计算差值
        int diff = costsA.size() - costsB.size();

        // 如果A的多
        if( diff > 0 ) {
            // 对A中costs按照成本差异升序排序（A中保证了o[1] >= o[0])
            Collections.sort(costsA, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o1[0] - (o2[1] - o2[0]);
                }
            });

            // 取出 diff/2 个元素
            int cnt = 0;
            while( cnt < diff / 2 ) {
                costsB.add(costsA.get(0));
                costsA.remove(0);
                cnt++;
            }
        }

        // 如果B的多
        if( diff < 0 ) {
            // 对B中costs按照成本差异升序排序（B中保证了o[0] >= o[1]）
            Collections.sort(costsB, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o1[1] - (o2[0] - o2[1]);
                }
            });

            // 取出 -diff/2 个元素
            int cnt = 0;
            while( cnt < -diff / 2 ) {
                costsA.add(costsB.get(0));
                costsB.remove(0);
                cnt++;
            }
        }

        // 计算结果
        int ret = 0;
        for( int[] a : costsA ) {
            ret += a[0];
        }

        for( int[] b : costsB ) {
            ret += b[1];
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] costs = new int[][]{
                {259, 770},
                {448, 54},
                {926, 667},
                {184, 139},
                {840, 118},
                {577, 469}
        };

        TwoCitySchedCost solution = new TwoCitySchedCost();
        System.out.println(solution.twoCitySchedCost(costs));
    }
}
