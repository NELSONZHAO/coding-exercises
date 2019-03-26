/**
 * Created by Nelson on 2019/3/26.
 */

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {
        // 思路：虚拟头结点
        if( head == null || head.next == null )
            return head;

        // 建立虚拟结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 双指针
        ListNode prev = dummy;
        ListNode curr = head; // curr指向当前待考虑结点

        while( curr != null ) {

            while( curr.next != null && curr.val == curr.next.val ) {
                curr = curr.next;
            }

            // 此时如果有重复，curr指向重复元素的最后一个；否则，curr在prev的下一个
            // prev指向的是当前不重复链表的最后一个元素
            if( prev.next == curr ) {
                prev = prev.next;
            } else {
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 1, 2, 3, 3, 3, 4, 5, 5};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        System.out.println("Delete before: ");
        linkedList.printList(head);
        System.out.println("\nDelete after: ");

        DeleteDuplicatesII solution = new DeleteDuplicatesII();
        linkedList.printList(solution.deleteDuplicates(head));
    }
}
