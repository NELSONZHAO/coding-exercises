/**
 * Created by Nelson on 2019/3/20.
 */

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromic {

    public String longestPalindromic(String s) {
        // 思路：动态规划
        // 状态：f(i, j)代表s[i...j]是否为回文字符串，其中j>=i
        // 状态初始化：f(i, i) = true;
        // 状态转移：f(i, j) = (j == i + 1) ? (s[j] == s[i]) : (f(i+1, j-1) && s[i] == s[j])
        // 注意：由于f(i, j)依赖于f(i+1, j-1)，因此需要自底向上，自左向右地更新
        // 时间复杂度：O(n2)
        // 空间复杂度：O(n2)

        int len = s.length();
        if( len <= 1 )
            return s;

        // 初始化矩阵
        boolean[][] memo = new boolean[len][len];
        // 初始化对角线
        for( int i = 0; i < len; i++ )
            memo[i][i] = true;

        // 动态规划DP
        // 从倒数第二行开始
        // 记录最长子串的索引
        int m = 0;
        int n = 0;
        int maxLen = 0;

        for( int i = len - 2; i >= 0; i-- ) {
            for( int j = i + 1; j < len; j++ ) {
                memo[i][j] = (j == i + 1) ? s.charAt(i) == s.charAt(j) : (memo[i+1][j-1] && s.charAt(i) == s.charAt(j));

                if( memo[i][j] && j - i + 1 > maxLen ) {
                    m = i;
                    n = j;
                    maxLen = j - i + 1;
                }
            }
        }

        // 返回结果
        return s.substring(m, n+1);
    }

    public static void main(String[] args) {
        // 测试用例
        LongestPalindromic solution = new LongestPalindromic();

        String s1 = "aaaa";
        String s2 = "aacjuscaa";
        String s3 = "cbba";

        System.out.println(solution.longestPalindromic(s1));
        System.out.println(solution.longestPalindromic(s2));
        System.out.println(solution.longestPalindromic(s3));
    }
}
