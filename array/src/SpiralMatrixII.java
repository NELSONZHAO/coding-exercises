/**
 * Created by Nelson on 2019/9/24.
 */
public class SpiralMatrixII {

    public int[][] spiralMatrix(int n) {

        if( n == 0 )
            return new int[][]{{}};

        // 声明数组
        int[][] res = new int[n][n];

        // 定义访问状态
        boolean[][] visited = new boolean[n][n];

        // 定义索引号
        int r = 0;
        int c = 0;

        // 定义方向
        int[][] direction = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int di = 0;

        // 定义当前数字
        int i = 0;

        while( i < n * n ) {
            res[r][c] = ++i;
            visited[r][c] = true;

            // 更新索引
            int nr = r + direction[di][0];
            int nc = c + direction[di][1];

            // 判断合法性
            if( nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] ) {
                r = nr;
                c = nc;
            } else {
                di = ++di % 4;
                r = r + direction[di][0];
                c = c + direction[di][1];
            }
        }

        return res;
    }
}
