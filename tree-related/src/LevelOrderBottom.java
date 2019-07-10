/**
 * Created by Nelson on 2019/7/10.
 */

/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */

import java.util.*;
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 思路：使用栈存储每一层的结果
        // 倒序遍历最终的结果链表
        List<List<Integer>> res = new ArrayList<>();

        if( root == null ) {
            return res;
        }

        // 队列
        Queue<TreeNode> q = new LinkedList<>();
        Stack<ArrayList> stack = new Stack<>();

        q.offer(root);

        while( !q.isEmpty() ) {
            int levelLen = q.size();

            ArrayList<Integer> subList = new ArrayList<>();

            for( int i = 0; i < levelLen; i++ ) {
                TreeNode node = q.poll();

                subList.add(node.val);

                if( node.left != null )
                    q.offer(node.left);

                if( node.right != null )
                    q.offer(node.right);
            }

            stack.push(subList);
        }

        // 弹出
        while( !stack.empty() ) {
            res.add(stack.pop());
        }

        return res;
    }
}
