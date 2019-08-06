/**
 * Created by Nelson on 2019/8/6.
 */

import java.lang.reflect.Parameter;
import java.util.*;
public class PalindromePartition  {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> partition(String s) {
            // 思路：回溯法
            if( s.equals("") )
                return res;

            helper(s, 0, new ArrayList<String>());

            return res;
        }

        // s[index...]为待处理部分
        // strings是已经处理的部分
        private void helper(String s, int index, ArrayList<String> strings) {
            // 递归终止条件
            if( index == s.length() ) {
                res.add((ArrayList<String>)strings.clone());
                return;
            }

            // 递归过程
            for( int i = index+1; i <= s.length(); i++ ) {
                // 判断当前s[index...i]区间的是不是回文
                String subStr = s.substring(index, i);
                // 如果是回文，加入strings并处理其他元素
                if( isPalindrome(subStr) ) {
                    ArrayList<String> stringsCopy = (ArrayList<String>)strings.clone();
                    stringsCopy.add(subStr);

                    helper(s, i, stringsCopy);
                }
            }

            return;
        }

        private boolean isPalindrome(String s) {
            if( s.equals("") )
                return false;

            if( s.length() == 1 )
                return true;

            int l = 0;
            int r = s.length() - 1;

            while( l <= r ) {
                if( s.charAt(l) != s.charAt(r) )
                    return false;
                l++;
                r--;
            }

            return true;
        }

        public static void main(String[] args) {
            // 测试用例
            String s = "aab";
            PalindromePartition solution = new PalindromePartition();
            List<List<String>> res = solution.partition(s);
        }
}
