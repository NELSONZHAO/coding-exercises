/**
 * Created by Nelson on 2019/7/4.
 */

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */

import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {
        // 思路：使用栈数据结构
        if( s == null )
            return true;

        Stack<Character> stack = new Stack<>();

        // 遍历字符串
        for( int i = 0; i < s.length(); i++ ) {
            // 当前字符
            char c = s.charAt(i);

            // 判断字符的类别
            // 左括号
            if( c == '(' || c == '[' || c == '{' ) {
                stack.push(c);
            } else { // 右括号
                // 判断栈是否空
                if( stack.empty() )
                    return false;

                char popChar = stack.pop();

                // 定义需要匹配
                char match = '(';
                switch (c) {
                    case ')':
                        match = '(';
                        break;
                    case ']':
                        match = '[';
                        break;
                    case '}':
                        match = '{';
                        break;
                }

                if( popChar != match ) {
                    return false;
                }
            }
        }

        if( !stack.empty() )
            return false;

        return true;
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "{{[[()]()[]]}}";
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid(s));
    }
}
