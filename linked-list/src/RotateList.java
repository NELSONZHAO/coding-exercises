/**
 * Created by Nelson on 2019/7/3.
 */

/**
 *  61. Rotate List
 *  https://leetcode.com/problems/rotate-list/
 *  类似处理方法，19题，删除倒数第N个结点
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        // 找到新的头、尾和旧的头
        // 穿针引线
        // 注意：将k处理成最后的余数
        // 和19题类似，倒数第k个值为新的头结点

        if( head == null || head.next == null || k <= 0 )
            return head;

        // 统计链表长度
        int listLen = 0;
        ListNode curr = head;

        while( curr != null ) {
            curr = curr.next;
            listLen++;
        }

        // 计算余数
        k = k % listLen;

        // 快慢指针找到新的头结点
        // 当k=0时，不需要移动任何指针
        if( k == 0 )
            return head;

        ListNode fastNode = head;
        ListNode slowNode = head;

        // 矫正fastNode
        while( k > 0 ) {
            fastNode = fastNode.next;
            k--;
        }

        // 移动快慢指针
        while( fastNode.next != null ) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        // 此时slowNode指向新的头结点的前一个结点
        // fastNode指向最后一个非空结点
        ListNode newHead = slowNode.next;
        slowNode.next = null;

        fastNode.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 2;

        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createList(arr);

        RotateList solution = new RotateList();
        ListNode ret = solution.rotateRight(head, k);

        linkedList.printList(ret);
    }
}

