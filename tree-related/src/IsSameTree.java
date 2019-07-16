/**
 * Created by Nelson on 2019/7/16.
 */

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class IsSameTree {

    public boolean isSameTree( TreeNode p, TreeNode q ) {
        // 递归
        // 递归结束条件
        if( p == null || q == null )
            return p == null && q == null;

        // 递归过程
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
