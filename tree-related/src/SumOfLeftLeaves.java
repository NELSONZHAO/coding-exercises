/**
 * Created by Nelson on 2019/7/19.
 */

/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 也可以统计右叶子的和
 */

import java.util.*;
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        // 思路：BFS或者递归
        // 递归终止条件
        if( root == null )
            return 0;

        int res = 0;
        if( root.left != null && root.left.left == null && root.left.right == null )
            res += root.left.val;

        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeavesBFS(TreeNode root) {
        // 使用BFS
        if( root == null )
            return 0;

        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while( !q.isEmpty() ) {
            int len = q.size();

            for( int i = 0; i < len; i++ ) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                    if (node.left.left == null && node.left.right == null)
                        res += node.left.val;
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return res;
    }
}
