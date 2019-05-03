/**
 * Created by Nelson on 2019/5/3.
 */

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LenOfLongestNoRepeatingSubstring {

    public int lengthOfLongestSubstring(String s) {
        // 思路：滑动窗口 + 集合存储
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)

        int len = s.length();
        if( len == 0 )
            return 0;

        int l = 0;
        int r = -1;
        int[] count = new int[256]; // 存储滑动窗口[l...r]中每个字符出现次数

        int ret = 0;

        while( l < len ) {

            // 如果r+1元素不在滑动窗口中，则纳入滑动窗口
            if( r + 1 < len && count[s.charAt(r+1)] == 0 ) {
                count[s.charAt(++r)]++;
            } else {
                // 移动指针l直到将s[r+1]对应的字符移除
                count[s.charAt(l++)]--;
            }

            // 更新ret
            ret = Math.max( ret, r - l + 1 );
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "abcabcbb";
        LenOfLongestNoRepeatingSubstring solution = new LenOfLongestNoRepeatingSubstring();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
