/**
 * Created by Nelson on 2019/3/24.
 */

/**
 * 206 Reverse List
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if( head == null )
            return head;

        // 定义指针
        ListNode prev = null;
        ListNode curr = head;

        while( curr != null ) {
            // next指针
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);

        System.out.println("reverse before: ");
        linkedList.printList(head);
        System.out.println();

        System.out.println("reverse after: ");
        ReverseList solution = new ReverseList();
        ListNode newHead = solution.reverseList(head);
        linkedList.printList(newHead);
    }
}
