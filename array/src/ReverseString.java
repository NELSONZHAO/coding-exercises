/**
 * Created by Nelson on 2019/4/29.
 */

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public String reverseString(String s) {
        // 思路：对撞指针
        int len = s.length();
        if( len <= 1 )
            return s;

        // 指针
        int l = 0;
        int r = len - 1;
        char[] chars = s.toCharArray();

        while( l < r ) {
            // 交换
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            // 移动指针
            l++;
            r--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "hello";
        ReverseString solution = new ReverseString();
        System.out.println(s);
        System.out.println(solution.reverseString(s));
    }
}
