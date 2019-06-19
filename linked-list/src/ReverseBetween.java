/**
 * Created by Nelson on 2019/6/19.
 */

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 问题：翻转链表中从[m...n]区间的元素
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 思路：
        // 待记录的指针：
        // m前面的指针
        // n的指针
        // 翻转后的m位置的指针
        if( head == null || head.next == null )
            return head;

        // 先把指针移动到m
        ListNode prev = null;
        ListNode curr = head;
        int cnt = 1;

        while( cnt < m && curr != null ) {
            prev = curr;
            curr = curr.next;
            cnt++;
        }

        // 此时prev指向m-1位置，curr指向m位置

        // 记录m-1位置指针
        ListNode conn = prev;
        // 记录翻转后的尾指针
        ListNode tail = curr;

        // 翻转链表
        while( cnt <= n && curr != null ) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

            cnt++;
        }

        // 引线连接
        if( conn == null ) {// 如果m从1开始
            head = prev;
        } else {
            conn.next = prev;
        }

        tail.next = curr;


        return head;
    }

    public static void main( String[] args ) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        linkedList.printList(head);

        int m = 1;
        int n = 4;

        ReverseBetween solution = new ReverseBetween();
        ListNode ret = solution.reverseBetween(head, m, n);
        linkedList.printList(ret);
    }
}
