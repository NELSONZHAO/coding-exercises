/**
 * Created by Nelson on 2019/4/21.
 */

/**
 * 1030. Matrix Cells in Distance Order
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 */
import java.util.*;

public class AllCellsDistOrder {

    // 解法1：将二维数组变成一维数组，自定义重载排序函数（根据曼哈顿距离排序）
    // 时间复杂度：O(nlogn)
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0){
        // 初始化一维数组
        int[][] ret = new int[R*C][2];

        for( int i = 0; i < R; i++ ) {
            for( int j = 0; j < C; j++ ) {
                ret[i * C + j] = new int[]{i, j};
            }
        }

        // 自定义排序
        Arrays.sort(ret, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0]-r0) + Math.abs(o1[1]-c0)
                        - (Math.abs(o2[0]-r0) + Math.abs(o2[1]-c0));
            }
        });

        return ret;
    }

    // 解法2：BFS广度优先遍历。可以将整个矩阵看做一个图，从离（r0,c0)最近的点开始遍历
    // 时间复杂度：O(n)
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        // 初始化数组存储当前坐标是否被遍历过（只要入队过就为true）
        boolean[][] visited = new boolean[R][C];
        // 默认为False
        for( int i = 0; i < R; i++ ) {
            Arrays.fill(visited[i], false);
        }

        // 返回值
        int[][] ret = new int[R*C][2];

        // 使用队列进行BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        // 初始化方向值
        int[] rowDirect = new int[]{0, 0, -1, 1};
        int[] colDirect = new int[]{-1, 1, 0, 0};

        // BFS
        int i = 0;
        while( !queue.isEmpty() ) {
            // 取出队首元素
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            ret[i++] = cell;

            // 提供周围元素
            for (int k = 0; k < 4; k++) {
                int newRow = r + rowDirect[k];
                int newCol = c + colDirect[k];

                if (newRow >= R || newCol >= C || newRow < 0 || newCol < 0 || visited[newRow][newCol]) {
                    continue;
                }

                queue.offer(new int[]{newRow, newCol});
                visited[newRow][newCol] = true;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        AllCellsDistOrder solution = new AllCellsDistOrder();
        int[][] ret = solution.allCellsDistOrder2(2, 3, 0, 1);

        for( int[] r : ret ) {
            System.out.println("(" + r[0] + ", " + r[1] + ")");
        }
    }
}
