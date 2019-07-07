/**
 * Created by Nelson on 2019/7/6.
 */

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 */

import java.util.*;

public class SimplifyPath {

    public String simplifyPath(String path) {
        // 思路：双端队列
        // 也可以使用栈，但要注意栈中的目录顺序是反的，最终返回时要重新开辟一个栈空间来翻转目录顺序
        Deque<String> dq = new ArrayDeque<>();

        // 将路径按照"/"分割成数组
        for( String token : path.split("/") ) {
            // 情况1：当前token为空，说明是重复/，或者当前为.，代表仍停留在当前目录
            if( token.length() == 0 || token.equals(".") ) {
                continue;
            } // 情况2：当前token为..，代表跳转至上一个目录
            else if( token.equals("..") ) {
                // 判断当前队列中是否有元素
                if( !dq.isEmpty() ) {
                    dq.pop();
                }
            } else {
                dq.push(token);
            }
        }

        // 处理队列中的元素
        StringBuilder sb = new StringBuilder();
        // 添加根目录
        sb.append("/");
        //
        while( !dq.isEmpty() ) {
            sb.append(dq.removeLast());
            if( !dq.isEmpty() ) {
                sb.append("/");
            }
        }

        return sb.toString();
    }

    public String simplifyPathII(String path) {
        // 思路：使用栈空间
        // 也可以使用栈，但要注意栈中的目录顺序是反的，最终返回时要重新开辟一个栈空间来翻转目录顺序
        Stack<String> stack = new Stack<>();

        // 遍历元素
        for( String s : path.split("/") ) {
            // 无效路径或当前路径
            if( s.equals("") || s.equals(".") ) {
                continue;
            } else if( s.equals("..") ) {
                // 跳转上一路径
                if( !stack.empty() ) {
                    stack.pop();
                }
            } else {
                // 其它情况
                stack.push(s);
            }
        }

        // 重新逆转目录
        Stack<String> st = new Stack<>();

        while( !stack.empty() ) {
            st.push(stack.pop());
        }
        // 生成有效目录
        StringBuilder sb = new StringBuilder();
        sb.append("/");

        while( !st.empty() ) {
            sb.append(st.pop());
            if( !st.empty() ) {
                sb.append("/");
            }
        }

        return sb.toString();
    }

    public static void main( String[] args ) {
        // 测试用例
        String path = new String("/home//foo/../machinelearning/./");
        SimplifyPath solution = new SimplifyPath();
        System.out.println(solution.simplifyPath(path));
        System.out.println(solution.simplifyPathII(path));
    }
}
