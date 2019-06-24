/**
 * Created by Nelson on 2019/6/24.
 */

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesII {

    public ListNode deleteDuplicates( ListNode head ) {
        // 思路：虚拟头结点
        // 关键点1：保留前面的指针，且保证prev满足的性质：当前不重复链表的最后一个结点
        // 关键点2：要维持一个区间[curr, next]，去除区间内重复值（优化：next也用curr来进行判断即可）

        if( head == null || head.next == null )
            return head;

        // 创建虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // prev指向当前不重复的最后一个结点
        ListNode prev = dummyNode;
        // curr指向当前待考虑结点
        ListNode curr = head;

        // 遍历每个结点，直到整个链表结束
        while( curr != null ) {

            // 当前待考虑结点值与下一个结点相同时，移动下一个结点
            while( curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // 判断curr是否移动过
            // 如果curr没有移动，说明curr没有重复，可以放心地将prev移动过去
            if( prev.next == curr ) {
                prev = prev.next;
            } else {
                // 如果curr被移动过，说明此时curr指向重复元素的最后一个
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 测试用例
        LinkedList linkedList = new LinkedList();
        int[] arr = new int[]{1, 1};
        ListNode head = linkedList.createList(arr);
        linkedList.printList(head);

        RemoveDuplicatesII solution = new RemoveDuplicatesII();
        ListNode ret = solution.deleteDuplicates(head);
        linkedList.printList(ret);
    }
}
