/**
 * Created by Nelson on 2019/3/20.
 */

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        // 思路：贪心算法
        // 两个指针i与j，i指针去遍历s，j指针去遍历t
        // 当s遍历结束，返回true；否则返回false
        // 时间复杂度：O(s.length + t.length)

        int len1 = s.length();
        int len2 = t.length();

        if( len1 == 0 || len2 == 0 || len1 > len2 )
            return false;

        int i = 0;
        int j = 0;

        while( i < len1 && j < len2 ) {
            char cs = s.charAt(i);
            char ct = t.charAt(j);

            if( cs == ct ) {
                i++;
            }

            j++;
        }

        // 判断s是否被遍历结束
        if( i == len1 )
            return true;

        // 说明t已经被遍历结束，但s还未被遍历结束
        return false;
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "abc";
        String t = "ahbgdvc";

        IsSubsequence solution = new IsSubsequence();
        System.out.println(solution.isSubsequence(s, t));
    }
}
