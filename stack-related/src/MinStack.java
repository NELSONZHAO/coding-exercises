/**
 * Created by Nelson on 2019/7/11.
 */

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/
 */

import java.util.*;
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 入栈
        stack.push(x);

        if( minStack.empty() )
            minStack.push(x);

        else {
            if( x <= minStack.peek() )
                minStack.push(x);
        }

        return;
    }

    public void pop() {
        // 这里不能写成minStack.peek() == stack.peek()，即使值相同，也会返回false
        int minElement = minStack.peek();

        if( stack.peek() == minElement ) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

//["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
//        [[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
**/