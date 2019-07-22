/**
 * Created by Nelson on 2019/6/29.
 */

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/
 */

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        // 思路
        // 思路：明确指针含义
        // 不同于数组的插入排序：对于当前待排序元素自后向前的比较
        // 链表由于只有单向访问，因此对于当前待排序元素，需要从头到已排序的最后一个结点进行比较
        if( head == null || head.next == null )
            return head;

        // 虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // prev为当前有序部分的最后一个结点
        ListNode prev = head;

        // curr为当前待排序结点
        ListNode curr = head.next;

        // 遍历所有待排序结点
        while( curr != null ) {
            // 判断当前结点值是否比已排序部分的最后一个值大，如果大就直接移动指针
            if( curr.val >= prev.val ) {
                prev = curr;
                curr = curr.next;
            } else {
                // 如果没有，就需要从链表头部进行搜索，找到当前结点合适的插入位置
                ListNode iterNode = dummyNode;
                // 如果已排序的结点比当前结点小，就继续移动指针
                while( iterNode.next.val < curr.val && iterNode != prev ) {
                    iterNode = iterNode.next;
                }

                // 此时iterNode的下一个结点就是curr元素待插入的位置
                ListNode partNode = iterNode.next;  // 已排好序剩余部分的头结点
                ListNode next = curr.next;  // curr已经搜索完毕，记录未搜索的下一个结点

                // 移动指针
                iterNode.next = curr;
                curr.next = partNode;

                // 更新curr
                curr = next;
                prev.next = curr; // 重要！！！第一次忽略了这个，导致Memory溢出
            }
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 测试用例
        LinkedList linkedList = new LinkedList();
        int[] arr = new int[]{4, 2, 1, 3};
        ListNode head = linkedList.createList(arr);

        InsertionSortList solution = new InsertionSortList();
        ListNode sortedList = solution.insertionSortList(head);
        linkedList.printList(sortedList);
    }
}
