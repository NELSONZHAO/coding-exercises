/**
 * Created by Nelson on 2019/4/7.
 */

/**
 * 1021. Remove Outermost Parentheses
 * https://leetcode.com/problems/remove-outermost-parentheses/
 */

import java.util.*;
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String S) {
        // 思路：类似括号匹配问题，使用栈
        // 对于特殊情况需要加条件判断
        if( S.equals("") )
            return S;

        // 开辟一个栈空间，存储字符串中的括号
        Stack<Character> stack = new Stack<>();
        // 返回值
        StringBuilder ret = new StringBuilder();

        // 遍历字符串
        for( int i = 0; i < S.length(); i++ ) {
            // 记录当前括号
            char c = S.charAt(i);

            // 如果当前c是左括号，入栈
            if( c == '(' ) {
                if( stack.size() > 0 ) {
                    ret.append('(');
                }
                stack.push(c);
            } else {
                // 如果是右括号，再判断当前栈中元素个数
                if( stack.size() > 1 ) {
                    ret.append(')');
                }
                // 出栈
                stack.pop();
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        // 测试用例
        String S = "(()())(())";
        RemoveOuterParentheses solution = new RemoveOuterParentheses();
        System.out.println("Before: " + S);
        System.out.println("After: " + solution.removeOuterParentheses(S));

        String S2 = "(()())(()(()))";
        System.out.println("\nBefore: " + S2);
        System.out.println("After: " + solution.removeOuterParentheses(S2));
    }
}
