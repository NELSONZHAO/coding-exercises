/**
 * Created by Nelson on 2019/3/28.
 */

/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 思路：
        if( head == null || head.next ==null || k <= 1 )
            return head;

        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;

        // 用来记录当前访问了多少个结点
        int cnt = 0;

        while( head != null ) {
            cnt++;
            // 如果当前访问结点是k的整数倍，就翻转从(start, head]的结点，并返回头结点
            if( cnt % k == 0 ) {
                start = reverseList(start, head.next);
                head = start.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;

    }

    private ListNode reverseList(ListNode start, ListNode end) {
        // 对链表 ( start, end ) 开区间内结点进行反转
        if( start == end )
            return start;

        ListNode prev = start;
        ListNode curr = prev.next;

        // 记录翻转后的新的头结点
        ListNode newFirst = end;

        while( curr != end ) {
            ListNode next = curr;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        start.next = prev;
        newFirst.next = curr;

        return newFirst;

    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        System.out.println("Before swap: ");
        linkedList.printList(head);

        System.out.println("\nAfter swap: ");
        ReverseKGroup solution = new ReverseKGroup();
        linkedList.printList(solution.reverseKGroup(head, k));
    }
}
