/**
 * Created by Nelson on 2019/3/27.
 */

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 思路：虚拟头结点 + 归并排序中merge操作的思路进行合并
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // 遍历
        while( l1 != null && l2 != null ) {

            if( l1.val < l2.val ) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        // 某个已经遍历结束
        if( l1 == null ) {
            curr.next = l2;
        }
        if( l2 == null ) {
            curr.next = l1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr1 = new int[]{1, 2, 4, 6, 7, 7, 9};
        int[] arr2 = new int[]{1, 3, 4, 8};

        LinkedList linkedList = new LinkedList();
        ListNode l1 = linkedList.createList(arr1);
        ListNode l2 = linkedList.createList(arr2);

        MergeTwoLists solution = new MergeTwoLists();
        linkedList.printList(solution.mergeTwoLists(l1, l2));
    }
}
