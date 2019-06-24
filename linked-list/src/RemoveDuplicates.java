/**
 * Created by Nelson on 2019/6/24.
 */

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 参见对比82题
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        // 关键点：对于重复元素，保留第一个还是最后一个的问题
        // 保留第一个，无需虚拟头结点
        // 保留最后一个，需要虚拟头结点

        if (head == null || head.next == null)
            return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode curr = head;

        // 保留重复元素的最后一个
        while( curr != null ) {
            while( curr.next != null && curr.val == curr.next.val ) {
                curr = curr.next;
            }

            // 此时curr为不重复元素的最后一个
            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }

        return dummyNode.next;

    }

    public static void main(String[] args) {
        // 测试用例
        LinkedList linkedList = new LinkedList();
        int[] arr = new int[]{1, 1, 2, 3, 3};
        ListNode head = linkedList.createList(arr);
        linkedList.printList(head);

        RemoveDuplicates solution = new RemoveDuplicates();
        ListNode ret = solution.deleteDuplicates(head);
        linkedList.printList(ret);
    }
}
