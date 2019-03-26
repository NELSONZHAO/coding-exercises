/**
 * Created by Nelson on 2019/3/26.
 */

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        // 思路：虚拟头结点 + 删除操作
        if( head == null )
            return null;

        // 建立虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;

        while( curr.next != null ) {

            // 如果指针的下一个位置是需要删除的结点
            if (curr.next.val == val) {
                ListNode delNode = curr.next;
                curr.next = delNode.next;
                delNode.next = null; // 释放
            } else {
                // 如果不是
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{6, 2, 3, 4, 5, 6, 2, 7};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);

        RemoveElements solution = new RemoveElements();
        System.out.println("Delete before: ");
        linkedList.printList(head);
        System.out.println("\nDelete after: ");

        linkedList.printList(solution.removeElements(head, 6));
    }
}
