/**
 * Created by Nelson on 2019/2/24.
 */

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 思路：回溯法
 * 时间复杂度：O(3^n)
 * 空间复杂度：O(3^n)
  */

import java.util.*;

public class LetterCombinations {

    // 定义返回列表
    private List<String> ret = new LinkedList<>();

    // 映射表
    private String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    // 回溯
    private void findCombinations(String digits, int index, String s) {
        /**
         * 处理当前digits的index位置数字元素，并将返回的字母结果拼接在s后面
         */

        // 递归终止条件
        if( index == digits.length() ) {
            ret.add(s);
            return;
        }

        // 递归过程
        char c = digits.charAt(index);
        assert c >= '0' && c <= '9' && c != '1';
        String letters =letterMap[c - '0'];

        // 遍历当前字符的所有的字母
        for( int i = 0; i < letters.length(); i++ ) {
            StringBuilder sb = new StringBuilder(s);
            sb.append(letters.charAt(i));
            findCombinations(digits, index + 1, sb.toString());
        }

        return;
    }

    public List<String> letterCombinations(String digits) {

        if( digits.equals("") )
            return ret;

        findCombinations(digits, 0, "");

        return ret;
    }

    public static void main(String[] args) {
        String s = "234";

        LetterCombinations solution = new LetterCombinations();
        List<String> ret = solution.letterCombinations(s);

        for( int i = 0; i < ret.size(); i++ )
            System.out.println(ret.get(i));
    }
}
