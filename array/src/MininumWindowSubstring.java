/**
 * Created by Nelson on 2019/5/7.
 */

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MininumWindowSubstring {

    public String minWindow(String s, String t) {
        // 思路：滑动窗口
        // 1.先统计t中字符串的hash-table，考虑到题目都是大写字符，所以这里空间复杂度为O(1)
        // 2.维护一个滑动窗口[l...r]，维护滑动窗口中的元素hash-table
        // 3.判断当前窗口中的hash-table是否能够cover字符串t的内容（如果可以，更新最小窗口的边界和大小，然后移动左指针缩小窗口；苟泽移动右指针扩大窗口）

        int sLen = s.length();
        int tLen = t.length();

        if( sLen < tLen )
            return "";

        // 统计t中的元素
        int[] tSet = new int[256];
        for( char c : t.toCharArray() ) {
            tSet[c-'A']++;
        }

        // 滑动窗口
        int l = 0;
        int r = -1;
        int minL = l;
        int minR = -1;
        // 统计[l...r]区间
        int minWindowLen = sLen + 1;

        int[] sSet = new int[256];

        // 遍历
        while( l < sLen && r < sLen) {

            // 判断当前窗口是否符合要求
            // 如果满足要求
            if( r - l + 1 >= tLen && isContains(sSet, tSet) ) {
                // 判断窗口是不是比当前最小的小
                if( r - l + 1 < minWindowLen ) {
                    minWindowLen = r - l + 1;
                    minL = l;
                    minR = r;
                }

                // 滑动左边
                sSet[s.charAt(l++)-'A']--;
            } else if( r + 1 < sLen ) {
                // 把r+1位置元素纳入区间
                sSet[s.charAt(++r) - 'A']++;
            } else {
                break;
            }
        }

        return minWindowLen == sLen + 1 ? "" : s.substring(minL, minR + 1);
    }

    private boolean isContains(int[] a, int[] b) {
        // 判断b是否包含在a中
        for( int i = 0; i < b.length; i++ ) {
            if( a[i] < b[i] )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MininumWindowSubstring solution = new MininumWindowSubstring();
        System.out.println(solution.minWindow(s, t));
    }
}
