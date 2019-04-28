/**
 * Created by Nelson on 2019/4/28.
 */

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // 思路：对撞指针
        // 时间复杂度：O(n)

        int len = s.length();
        if( len == 0 || len == 1 )
            return true;

        // 对撞指针
        int l = 0;
        int r = len - 1;

        while( l <= r ) {

            char c1 = s.charAt(l);
            char c2 = s.charAt(r);

            // 获取有效字符
            if( isAlphaNumber(c1) && isAlphaNumber(c2) ) {
                if( Character.toLowerCase(c1) != Character.toLowerCase(c2) ) {
                    return false;
                }
                l++;
                r--;
            } else if ( !isAlphaNumber(c1) ) {
                l++;
            } else {
                r--;
            }
        }

        return true;
    }

    private boolean isAlphaNumber(char c) {
        // 返回一个字符是否为数字或者字母
        return ( c >= 'A' && c <= 'Z' ) || ( c >= 'a' && c <= 'z' ) || ( c >= '0' && c <= '9' );
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome solution = new ValidPalindrome();
        System.out.println(solution.isPalindrome(s));
    }
}
