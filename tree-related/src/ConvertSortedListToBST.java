/**
 * Created by Nelson on 2019/7/25.
 */

/**
 * 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        // 思路：递归

        // 递归结束条件
        if( head == null )
            return null;

        if( head.next == null )
            return new TreeNode(head.val);

        // 递归过程
        // 找到中位数结点
        ListNode slowNode = head;
        ListNode fastNode = head.next.next;

        while( fastNode != null && fastNode.next != null ) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        // 此时slowNode指向中位数结点的前一个
        ListNode midNode = slowNode.next;

        if( midNode == null )
            return null;

        // 构建根节点
        TreeNode root = new TreeNode(midNode.val);

        // 递归
        slowNode.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);

        return root;
    }
}
