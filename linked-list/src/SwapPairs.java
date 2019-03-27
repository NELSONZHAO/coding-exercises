/**
 * Created by Nelson on 2019/3/27.
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // 思路：复杂指针交换
        if( head == null || head.next == null )
            return head;

        // 设置指针
        // 虚拟指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // prev指向待交换两个结点的前一个结点；p1与p2指向待交换结点
        ListNode prev = dummy;


        while( prev.next != null && prev.next.next != null ) {
            ListNode p1 = prev.next;
            ListNode p2 = p1.next;

            // 交换
            // step1: p1指向p2的下一个
            p1.next = p2.next;
            // step2: p2指向p1
            p2.next = p1;
            // prev指向p2
            prev.next = p2;

            // 移动指针
            prev = p1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        System.out.println("Before swap: ");
        linkedList.printList(head);

        System.out.println("\nAfter swap: ");
        SwapPairs solution = new SwapPairs();
        linkedList.printList(solution.swapPairs(head));
    }
}
