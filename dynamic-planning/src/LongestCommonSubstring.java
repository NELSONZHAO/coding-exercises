/**
 * Created by Nelson on 2019/2/26.
 */

/**
 * 给定两个字符串，求其最长公共子串的长度，并返回最长公共子串
 */
public class LongestCommonSubstring {

    private int[][] memo;

    public int longestCommonSubstring(String s1, String s2){
        // 思路：动态规划
        // 定义状态：F(i, j)代表以s1[i]与s2[j]结尾的最长公共子串长度
        // 状态转移：F(i, j) = F(i-1, j-1) + 1 if s1[i] == s2[j] else 0

        if( s1.equals("") || s2.equals("") )
            return 0;

        // 定义一个记忆化矩阵memo
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];

        // 初始化矩阵第一行
        for( int j = 0; j < n; j++ )
            memo[0][j] = s1.charAt(0) == s2.charAt(j) ? 1 : 0;

        // 初始化矩阵第一列
        for( int i = 0; i < m; i++ )
            memo[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;

        // 进行动态规划迭代过程
        // 用res记录最大长度
        int res = 0;
        for( int i = 1; i < m; i++ ) {
            for( int j = 1; j < n; j++ ) {
                memo[i][j] = s1.charAt(i) == s2.charAt(j) ? memo[i-1][j-1]+1 : 0;
                res = Math.max( res, memo[i][j] );
            }
        }

        return res;
    }

    public String getSubstring(String s1, String s2) {
        // 返回s1和s2的最大公共子串
        // 从memo中寻找最大值
        int m = s1.length();
        int n = s2.length();

        int lcs = longestCommonSubstring(s1, s2);

        // 找到memo中存储最长子序列结果的索引位置
        int row = 0;
        int col = 0;
        for( int i = m-1; i >= 0; i-- ) {
            for( int j = n-1; j >= 0; j-- ) {
                if( memo[i][j] == lcs ) {
                    row = i;
                    col = j;
                }
            }
        }

        // 逆向返回结果
        StringBuilder sb = new StringBuilder();
        while( row >= 0 && col >= 0 ) {
            sb.insert(0, s1.charAt(row));
            row--;
            col--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "wherefni3China";
        String s2 = "wherekfiCAmerican";
        LongestCommonSubstring solution = new LongestCommonSubstring();
        System.out.println(solution.longestCommonSubstring(s1, s2));
        System.out.println(solution.getSubstring(s1, s2));
    }
}
