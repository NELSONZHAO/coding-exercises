/**
 * Created by Nelson on 2019/7/16.
 */

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */

import java.util.*;
public class MinDepthBT {

    // 思路1：递归
    public int minDepthRecursion( TreeNode root ) {
        // 递归终止条件
        if( root == null )
            return 0;

        // 递归过程
        // 左孩子的最小高度
        int leftMinDepth = minDepthRecursion(root.left);
        int rightMinDepth = minDepthRecursion(root.right);

        return leftMinDepth == 0 || rightMinDepth == 0 ? Math.max( leftMinDepth, rightMinDepth ) + 1 : Math.min( leftMinDepth, rightMinDepth ) + 1;
    }

    // 思路2：广度优先遍历
    public int minDepthBFS( TreeNode root ) {
        // 广度优先遍历
        if( root == null )
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer( root );

        // 初始化深度，为1
        int minDepth = 1;

        while( !q.isEmpty() ) {
            int len = q.size();

            for( int i = 0 ; i < len; i++ ) {
                TreeNode node = q.poll();

                // 如果是叶子结点，直接返回
                if( node.left == null && node.right == null )
                    return minDepth;

                if( node.left != null )
                    q.offer(node.left);

                if( node.right != null )
                    q.offer(node.right);
            }

            minDepth ++;
        }

        return minDepth;
    }
}
