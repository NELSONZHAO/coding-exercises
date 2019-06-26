/**
 * Created by Nelson on 2019/6/26.
 */

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 类似题目：25. Reverse Nodes in k-Group，24题是25题的K=2时的特殊版
 */
public class SwapNodesInPairs {

    public ListNode swapPairs( ListNode head ) {
        // 思路：虚拟头结点
        // 交错地穿针引线
        // 原则：定义清楚指针的含义，并且有限改变有指针结点前面结点的指针位置
        if( head == null || head.next == null )
            return head;

        // 建立虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // prev为当前已经完成交换的最后一个结点
        ListNode prev = dummyNode;
        ListNode curr = head;

        while( curr != null && curr.next != null ) {
            // 交换一对元素
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;

            // 移动到待考虑的下一对元素
            prev = curr;
            curr = curr.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5};
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);
        System.out.println("Before: ");
        linkedList.printList(head);

        SwapNodesInPairs solution = new SwapNodesInPairs();
        ListNode ret = solution.swapPairs(head);
        System.out.println("After: ");
        linkedList.printList(ret);
    }
}
