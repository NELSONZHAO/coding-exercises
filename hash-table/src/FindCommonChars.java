/**
 * Created by Nelson on 2019/5/12.
 */

/**
 * 1002. Find Common Characters
 * https://leetcode.com/problems/find-common-characters/
 */

import java.util.*;
public class FindCommonChars {

    public List<String> common(String[] A) {
        // 思路：hash-table
        // 遍历子串，不断更新hash-table
        // 时间复杂度：O(n)  n为字符串个数
        int len = A.length;
        List<String> ret = new ArrayList<>();

        if( len == 0 )
            return ret;

        // 构建hash-table，存储了当前所有遍历过的字符串中的公共字符
        int[] hashMap = new int[26];

        // 遍历第一个字符串
        for( char c : A[0].toCharArray() ) {
            hashMap[c-'a']++;
        }

        // 遍历剩余字符串，并不断更新hash-table
        for( int i = 1; i < len; i++ ) {
            // tempFreq存储当前字符串中的字符
            int[] tempFreq = new int[26];
            String s = A[i];
            for( char c : s.toCharArray() ) {
                tempFreq[c-'a']++;
            }

            // 更新hash-table
            for( int k = 0; k < 26; k++ ) {
                hashMap[k] = Math.min( hashMap[k], tempFreq[k] );
            }
        }

        // hash-table已经存储了最后结果
        for( int i = 0; i < 26; i++ ) {
            int freq = hashMap[i];
            while( freq > 0 ) {
                ret.add( String.valueOf((char)('a'+i)) );
                freq--;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        String[] A = new String[]{"cool","lock","cook"};
        FindCommonChars solution = new FindCommonChars();
        List<String> ret = solution.common(A);
        for( String s : ret ) {
            System.out.print(s + " ");
        }
    }
}
