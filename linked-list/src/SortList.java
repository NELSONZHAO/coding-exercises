/**
 * Created by Nelson on 2019/6/25.
 */

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        // 思路：采用归并排序的思路
        // 递归

        // 递归结束条件
        if( head == null || head.next == null ) {
            return head;
        }

        // 递归过程
        // 分别对链表左半部分与右半部分排序
        // 快慢指针寻找中点
        ListNode fastNode = head.next;
        ListNode slowNode = head;

        while( fastNode != null && fastNode.next != null ) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        // 此时slowNode是左半部分的最后一个结点，其下一个结点为右半部分的第一个结点
        ListNode remainPart = slowNode.next;
        slowNode.next = null;

        // 左边排序
        ListNode leftList = sortList(head);
        // 右边排序
        ListNode rightList = sortList(remainPart);
        // 合并两个有序链表
        ListNode mergedSortedList = __merge(leftList, rightList);

        return mergedSortedList;
    }

    private ListNode __merge(ListNode l1, ListNode l2) {
        // 合并两个有序链表
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;

        while( l1 != null && l2 != null ) {
            if( l1.val <= l2.val ) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        if( l1 == null ) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 测试用例
        LinkedList linkedList = new LinkedList();
        int[] arr = new int[]{4, 5, 6, 7, 1, 3, 2, 0};
        ListNode head = linkedList.createList(arr);
        System.out.println("Before: ");
        linkedList.printList(head);

        SortList solution = new SortList();
        ListNode sortedList = solution.sortList(head);
        System.out.println("After: ");
        linkedList.printList(sortedList);
    }
}
