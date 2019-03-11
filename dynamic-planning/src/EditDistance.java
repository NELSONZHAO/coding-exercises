/**
 * Created by Nelson on 2019/3/11.
 */

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 */

public class EditDistance {

    public int editDistance(String word1, String word2) {
        // 思路：动态规划
        // 定义状态：f(i, j)代表word1[0...i]字符串与word2[0...j]字符串的编辑距离
        // 状态转移：
        // if word1[i] == word2[j], f(i, j) = f(i-1, j-1)
        // else f(i, j) = min( f(i-1, j) + 1, f(i, j-1) + 1, f(i-1, j-1) + 1 )
        // 时间复杂度：O(word1.length * word2.length)
        // 空间复杂度：O(word1.length * word2.length)

        if( word1.length() == 0 || word2.length() == 0 )
            return Math.max(word1.length(), word2.length());

        int len1 = word1.length();
        int len2 = word2.length();

        // 构造矩阵（其中第一行代表空字符串到word2[0...j]字符串的编辑距离，第一列代表空字符串到word1[0...i]字符串的编辑距离）
        int[][] memo = new int[len1+1][len2+1];

        // 初始化第一行
        for( int j = 0; j <= len2; j++ ) {
            memo[0][j] = j;
        }

        // 初始化第一列
        for( int i = 0; i <= len1; i++ ) {
            memo[i][0] = i;
        }

        // 动态规划
        for( int i = 1; i <= len1; i++ ) {
            for( int j = 1; j <= len2; j++ ) {
                // 判断
                if( word1.charAt(i-1) == word2.charAt(j-1) )
                    memo[i][j] = memo[i-1][j-1];
                else
                    memo[i][j] = Math.min( Math.min( memo[i-1][j] + 1, memo[i][j-1] + 1 ), memo[i-1][j-1] + 1 );
            }
        }

        return memo[len1][len2];
    }

    public static void main(String[] args) {
        // 测试用例
        String word1 = "machine";
        String word2 = "maple";

        EditDistance solution = new EditDistance();
        System.out.println(solution.editDistance(word1, word2));
    }
}
