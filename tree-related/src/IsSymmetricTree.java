/**
 * Created by Nelson on 2019/7/17.
 */

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 */
import java.util.*;
public class IsSymmetricTree {

    // 递归方法
    // 思路：判断一棵树是不是对称 等价于 判断两棵树是不是镜像
    public boolean isSymmetricTree( TreeNode root ) {
        if( root == null )
            return true;

        return isMirrorTree( root, root );
    }

    private boolean isMirrorTree( TreeNode node1, TreeNode node2 ) {
        // 递归结束条件
        if( node1 == null || node2 == null )
            return node1 == null && node2 == null;

        // 递归过程
        return node1.val == node2.val && isMirrorTree(node1.left, node2.right) && isMirrorTree(node1.right, node2.left);
    }

    // 遍历方法
    // 思路：广度优先遍历，使用队列。对于遍历到的连续两个结点应该是相等的值
    // 对于同一层遍历到的两个结点，先放入node1.left和node2.right；再放入node1.right和node2.left
    public boolean isSymmetricTreeBFS( TreeNode root ) {

        if( root == null )
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while( !q.isEmpty() ) {

            // 取出顶部两个元素
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();

            // 判断这两个元素
            if( node1 == null && node2 == null )
                continue;

            if( node1 == null || node2 == null )
                return false;

            if( node1.val != node2.val )
                return false;

            // 加入新元素
            q.offer(node1.left);
            q.offer(node2.right);

            q.offer(node1.right);
            q.offer(node2.left);
        }

        return true;
    }
}
