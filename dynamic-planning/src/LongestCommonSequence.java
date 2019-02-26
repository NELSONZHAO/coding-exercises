/**
 * Created by Nelson on 2019/2/26.
 */

/**
 * 给定两个字符串s1和s2，返回最长公共子序列长度及对应的最长公共子序列
 */

public class LongestCommonSequence {

    private int[][] memo;
    public int longestCommonSequence(String s1, String s2) {
        // 思路：动态规划
        // 定义状态：F(i, j)代表s1前i个字符与s2前j个字符的最长公共子序列长度
        // 状态转移：F(i, j) =  F(i-1, j-1) + 1 if s1.charAt(i) == s2.charAt(j) else max{F(i-1,j), F(i, j-1)}

        if( s1.equals("") || s2.equals("") )
            return 0;

        // 初始化
        int m = s1.length();
        int n = s2.length();

        // 此时不需要对m=0和n=0特殊处理
        memo = new int[m+1][n+1];

        // 动态规划
        for( int i = 1; i <= m; i++ ) {
            for( int j = 1; j <= n; j++ ) {
                memo[i][j] = s1.charAt(i-1) == s2.charAt(j-1) ? memo[i-1][j-1] + 1 : Math.max(memo[i-1][j], memo[i][j-1]);
            }
        }

        return memo[m][n];
    }

    public String getSequence(String s1, String s2) {
        if( s1.equals("") || s2.equals("") )
            return null;

        // 从memo的右下角元素开始找
        int row = s1.length();
        int col = s2.length();

        StringBuilder sb = new StringBuilder();
        while( row > 0 && col > 0 ) {
            if( s1.charAt(row - 1) == s2.charAt(col - 1) ) {
                sb.insert(0, s1.charAt(row - 1));
                row--;
                col--;
            } else if( memo[row-1][col] > memo[row][col-1] ) {
                row--;
            }
            else {
                col--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "a1b3c4de5";
        String s2 = "ab78fcd3e";
        LongestCommonSequence solution = new LongestCommonSequence();
        System.out.println(solution.longestCommonSequence(s1, s2));
        System.out.println(solution.getSequence(s1, s2));
    }
}
