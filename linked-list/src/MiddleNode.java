/**
 * Created by Nelson on 2019/3/26.
 */

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        // 思路：快慢指针
        if( head == null || head.next == null )
            return head;

        // 定义指针
        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);

        MiddleNode solution = new MiddleNode();
        System.out.println(solution.middleNode(head).val);
    }
}
