/**
 * Created by Nelson on 2019/5/1.
 */

/**
 * 345. Reverse Vowels of a String
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        // 思路：对撞指针
        // 时间复杂度：O(n)
        int len = s.length();
        if( len <= 1 )
            return s;

        char[] strings = s.toCharArray();

        // 双指针
        int l = 0;
        int r = len - 1;

        while( true ) {
            // 找到对应待交换的字符
            while( l < len && !isVowel(strings[l]) ) {
                l++;
            }

            while( r >= 0 && !isVowel(strings[r]) ) {
                r--;
            }

            if( l > r )
                break;

            // 交换
            char temp = strings[l];
            strings[l] = strings[r];
            strings[r] = temp;

            // 移动指针
            l++;
            r--;
        }

        return new String(strings);
    }

    private boolean isVowel(char c) {
        // 判断一个字符串是否为元音
        char ch = Character.toLowerCase(c);
        return ( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' );
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "leetcode";
        ReverseVowels solution = new ReverseVowels();
        System.out.println(solution.reverseVowels(s));
    }
}
