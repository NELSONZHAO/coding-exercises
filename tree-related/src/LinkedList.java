/**
 * Created by Nelson on 2019/3/24.
 */

/**
 * Create a list
 */

class ListNode {
    ListNode next;
    int val;
    public ListNode(int x) {
        this.val =  x;
    }
}

public class LinkedList {

    public ListNode createList(int[] arr) {

        //
        int n = arr.length;
        if (n == 0)
            return null;

        // 初始化头指针
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
    }

    return head;
}

    public void printList(ListNode head) {

        if( head == null )
            return;

        while( head != null ) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args){
        // 测试用例
        int[] arr = new int[]{1, 2, 3, 4, 5};
        LinkedList solution = new LinkedList();
        ListNode head = solution.createList(arr);
        solution.printList(head);
    }
}
