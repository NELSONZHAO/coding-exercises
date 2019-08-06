/**
 * Created by Nelson on 2019/7/15.
 */


/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

import java.util.*;
public class MergeKSortedLists {

    public ListNode mergeKSortedLists( ListNode[] lists ) {
        // 有序链表的k路归并
        // 思路：优先队列
        int k = lists.length;
        if( k == 0 )
            return null;

        Queue<ListNode> pq = new PriorityQueue<>(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        // 将k个链表入队
        for( ListNode node : lists ) {
            if( node != null ) {
                pq.offer(node);
            }
        }

        // 构造虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while( !pq.isEmpty() ) {
            ListNode node = pq.poll();
            curr.next = new ListNode(node.val);
            curr = curr.next;

            // 将node剩余部分继续入队
            if( node.next != null )
                pq.offer(node.next);
        }

        return dummyNode.next;
    }
}
