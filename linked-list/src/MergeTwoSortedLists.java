/**
 * Created by Nelson on 2019/6/25.
 */

/** 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 思路：虚拟头结点+穿针引线
        // 归并排序的思路
        if( l1 == null )
            return l2;
        if( l2 == null )
            return l1;

        // 定义虚拟结点
        ListNode dummyNode = new ListNode(-1);
        // 定义针
        // prev为当前已合并的最后一个结点
        ListNode prev = dummyNode;

        // 遍历两个链表
        while( l1 != null && l2 != null ) {
            // 当l1的值更小时
            if( l1.val <= l2.val ) {
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;
            } else { // 否则，当l2的值更小时
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
            }
        }

        // 此时将还未消耗完的结点拼接
        if( l1 == null ) {
            // 说明l2还有
            prev.next = l2;
        } else {
            prev.next = l1;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 测试用例
        LinkedList linkedList = new LinkedList();
        int[] arr1 = new int[]{1, 2, 3};
        ListNode l1 = linkedList.createList(arr1);
        int[] arr2 = new int[]{2, 4, 5};
        ListNode l2 = linkedList.createList(arr2);

        //
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode mergedLists = solution.mergeTwoLists(l1, l2);
        linkedList.printList(mergedLists);
    }
}
