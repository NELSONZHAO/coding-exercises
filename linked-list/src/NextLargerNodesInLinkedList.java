/**
 * Created by Nelson on 2019/6/20.
 */

/**
 * 1019. Next Greater Node In Linked List
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */

import java.util.*;
public class NextLargerNodesInLinkedList {

    public int[] nextLargerNodes( ListNode head ) {
        // 思路：使用stack（不转化为数组）
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        if( head == null )
            return new int[]{};

        // 创建结果表（由于不知道链表长度，所以用ArrayList创建
        List<Integer> retList = new ArrayList<>();

        // 创建栈
        Stack<Integer> stack = new Stack<>();

        int index = 0; // 记录当前访问到链表中的第几个元素

        while( head != null ) {

            while( !stack.empty() && head.val > retList.get(stack.peek()) )
                retList.set( stack.pop(), head.val );

            retList.add(head.val);
            stack.push(index++);
            head = head.next;
        }

        // 处理剩余部分（无解的部分）
        while( !stack.empty() ) {
            retList.set(stack.pop(), 0);
        }

        // 转换到结果
        int[] ret = new int[retList.size()];
        for( int i = 0; i < retList.size(); i++ ) {
            ret[i] = retList.get(i);
        }

        return ret;
//        // 思路：将链表转换为数组
//        // 额外开辟stack来处理
//
//        if( head == null )
//            return new int[]{};
//
//        // 转换为数组
//        List<Integer> list = new ArrayList<>();
//        while( head != null ) {
//            list.add(head.val);
//            head = head.next;
//        }
//
//        // 创建返回的数组和栈
//        int[] ret = new int[list.size()];
//        Stack<Integer> stack = new Stack<>();
//
//        // 遍历链表元素
//        // stack中推入当前访问链表元素的索引
//        for( int i = 0; i < list.size(); i++ ) {
//            while( !stack.empty() && list.get(i) > list.get(stack.peek()) )
//                ret[stack.pop()] = list.get(i);
//            stack.push(i);
//        }
//
//        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{2, 1, 5};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        linkedList.printList(head);

        NextLargerNodesInLinkedList solution = new NextLargerNodesInLinkedList();
        int[] ret = solution.nextLargerNodes(head);
        for( int i = 0; i < ret.length; i++ ) {
            System.out.print(ret[i] + " ");
        }
    }
}
