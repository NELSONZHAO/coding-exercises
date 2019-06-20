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
        // 思路：将链表转换为数组
        // 额外开辟stack来处理

        if( head == null )
            return new int[]{};

        // 转换为数组
        List<Integer> list = new ArrayList<>();
        while( head != null ) {
            list.add(head.val);
            head = head.next;
        }

        // 创建返回的数组和栈
        int[] ret = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        // 遍历链表元素
        // stack中推入当前访问链表元素的索引
        for( int i = 0; i < list.size(); i++ ) {
            while( !stack.empty() && list.get(i) > list.get(stack.peek()) )
                ret[stack.pop()] = list.get(i);
            stack.push(i);
        }

        return ret;
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
