/**
 * Created by Nelson on 2019/7/3.
 */

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 思路：双指针+虚拟头结点
        if( head == null || n <= 0 )
            return head;

        // 虚拟结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 定义快慢指针
        ListNode fastNode = dummyNode;
        ListNode slowNode = dummyNode;

        // 矫正初始位置
        while( n >= 0 ) {
            fastNode = fastNode.next;
            n--;
        }

        // 移动快慢指针
        while( fastNode != null ) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        // 此时fastNode -> NULL
        // slowNode指向待删除结点之前
//        ListNode delNode = slowNode.next;
//        slowNode.next = delNode.next;
//        delNode.next = null;

        slowNode.next = slowNode.next.next;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int n = 2;
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        System.out.println("Before: ");
        linkedList.printList(head);

        RemoveNthFromEnd solution = new RemoveNthFromEnd();
        ListNode ret = solution.removeNthFromEnd(head, n);
        System.out.println("After: ");
        linkedList.printList(ret);
    }
}
