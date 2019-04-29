/**
 * Created by Nelson on 2019/4/29.
 */

/**
 * 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        // 思路：双指针 + 交替开关
        int len = s.length();
        if( len <= 1 )
            return s;

        boolean reverse = true;
        char[] chars = s.toCharArray();

        for( int i = 0; i < len; i += k ) {
            if( reverse ) {
                helper(chars, i, Math.min(i+k-1, len-1));
                reverse = false;
            } else {
                reverse = true;
            }
        }

        return new String(chars);
    }

    private void helper(char[] chars, int l, int r) {
        // 翻转chars[l...r]中字符

        while( l < r ) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            l++;
            r--;
        }

        return;
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "abcdefg";
        int k = 2;

        ReverseStringII solution = new ReverseStringII();
        System.out.println(solution.reverseStr(s, k));
    }
}
