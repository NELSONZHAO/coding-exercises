/**
 * Created by Nelson on 2019/8/16.
 */

/**
 * 链表每k个一组进行旋转，用递归求解
 */
public class ReverseKGroupRecursion {

    public ListNode reverseKGroup(ListNode root, int k) {
        //
        if( root == null )
            return null;

        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = root;

        ListNode node = reverseList(dummy, k);
        return node;
    }

    private ListNode reverseList(ListNode s, int k) {
        // 翻转链表从s结点开始往后k个元素，并返回翻转后的头结点


        // 递归结束条件
        if( s == null ) {
            return null;
        }

        // 记录好s结点
        ListNode conn = s;
        ListNode tail = s.next;

        ListNode prev = s;
        ListNode curr = s.next;

        int cnt = 0;
        while( curr != null && cnt < k ) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

            cnt++;
        }

        // 此时prev为新的头结点
        conn.next = prev;
        // tail为新的s
        tail.next = reverseList(tail, k);

        return prev;
    }

    public static void main(String[] args) {
        // 测试用例
        LinkedList list = new LinkedList();
        ListNode root = list.createList(new int[]{1,2,3,4,5});
        int k = 2;

        // 之前
        System.out.println("Before: ");
        list.printList(root);
        ReverseKGroupRecursion solution = new ReverseKGroupRecursion();
        ListNode head = solution.reverseKGroup(root, k);

        // 之后
        System.out.println("After: ");
        list.printList(head);
    }
}
