/**
 * Created by Nelson on 2019/7/3.
 */

/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 * 拼多多面试题
 * 考察链表操作最多的一道题
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        // 拼多多面试题
        // 思路：快慢指针 + 链表翻转 + 链表merge

        if( head == null || head.next == null )
            return;

        // 快慢指针将链表拆开
        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while( fastNode != null && fastNode.next != null ) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        // 此时slowNode为链表部分后半部分头结点的前一个结点
        ListNode rightPart = slowNode.next;
        slowNode.next = null;

        // 翻转rightPart部分并获取新的头结点
        ListNode prev = null;
        ListNode curr = rightPart;

        while( curr != null ) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 此时prev为翻转后的右半部分
        // merge以head为头结点的左半部分和以prev为头结点的右半部分
        ListNode p1 = head;
        ListNode p2 = prev;

        while( p1 != null && p2 != null ) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            // 穿针引线
            p1.next = p2;
            p2.next = next1;

            // 更新p1和p2
            p1 = next1;
            p2 = next2;
        }

        return;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        System.out.println("Before: ");
        linkedList.printList(head);

        ReorderList solution = new ReorderList();
        solution.reorderList(head);
        System.out.println("After: ");
        linkedList.printList(head);
    }
}
