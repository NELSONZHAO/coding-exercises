/**
 * Created by Nelson on 2019/7/10.
 */

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */

import java.util.*;
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 思路：判断奇偶行
        List<List<Integer>> res = new ArrayList<>();

        if( root == null )
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1;

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

            if( level % 2 == 0 ) {
                Stack<Integer> stack = new Stack<>();

                for( int k = 0; k < subList.size(); k++ ) {
                    stack.push(subList.get(k));
                }

                //
                subList.clear();
                while( !stack.empty() ) {
                    subList.add(stack.pop());
                }
            }

            level++;
            res.add(subList);
        }

        return res;
    }
}
