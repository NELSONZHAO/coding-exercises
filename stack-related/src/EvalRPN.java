/**
 * Created by Nelson on 2019/7/4.
 */

/**
 * 求解逆波兰表达式
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */

import java.util.*;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        // 思路：栈空间
        // 遇到符号，弹出栈顶元素，计算结果，再压入栈
        // 遇到数字，压入栈

        // 栈中始终存储的是数字
        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < tokens.length; i++ ) {
            String s = tokens[i];

            // 如果是符号
            if( s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ) {
                // 抛出异常
                if( stack.empty() ) {
                    throw new IllegalArgumentException();
                }

                // 弹出栈顶元素和下一个元素
                int sec = stack.pop();
                int fst = stack.pop();

                if( s.equals("+") ) {
                    stack.push( fst + sec );
                } else if( s.equals("-") ) {
                    stack.push( fst - sec );
                } else if( s.equals("*") ) {
                    stack.push( fst * sec );
                } else {
                    assert( s.equals("/") );
                    stack.push( fst / sec );
                }
            } else {
                // 如果是数字
                int num = Integer.parseInt(s);
                stack.push(num);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        // 测试用例
        String[] tokens = new String[]{"2", "1", "/", "4", "*", "1", "-"};
        EvalRPN solution = new EvalRPN();
        System.out.println(solution.evalRPN(tokens));
    }
}
