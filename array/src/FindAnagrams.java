/**
 * Created by Nelson on 2019/5/5.
 */

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

import java.util.*;
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        // 思路：滑动窗口
        // 维持一个[l...r]的窗口，对比[l...r]窗口中元素的个数和具体元素和p中是否相等
        // 如果相等就返回l的值
        // 时间复杂度：O(n)
        // 空间复杂度：O(1)

        int sLen = s.length();
        int pLen = p.length();

        List<Integer> ret = new ArrayList<>();

        if( sLen < pLen ) {
            return ret;
        }

        // 统计p中元素
        int[] pFreq = new int[26];
        for( char c : p.toCharArray() ) {
            pFreq[c-'a']++;
        }

        // 滑动指针
        int l = 0;
        int r = -1;
        // 统计window中的元素
        int[] windowFreq = new int[26];
        // 对比[l...r]中字符串是否是p的Anagram

        while( r + 1 < sLen ) {
            // 将第r个元素纳入窗口
            windowFreq[s.charAt(++r)-'a']++;

            // 判断当前窗口元素是否超过规定大小，如果超过p的长度，则移动左指针
            if( r - l + 1 > pLen ) {
                windowFreq[s.charAt(l++)-'a']--;
            }

            // 判断是否符合要求
            if( r - l + 1 == pLen && isSame(pFreq, windowFreq) ) {
                ret.add(l);
            }
        }

        return ret;

    }

    private boolean isSame(int[] a, int[] b) {
        if( a.length != b.length )
            return false;

        // 判断两个数组是否相同
        for( int i = 0; i < a.length; i++ ) {
            if( a[i] != b[i] )
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "abcbacab";
        String p = "abc";

        FindAnagrams solution = new FindAnagrams();
        List<Integer> ret = solution.findAnagrams(s, p);

        for( Integer e : ret ) {
            System.out.println(e);
        }
    }
}
