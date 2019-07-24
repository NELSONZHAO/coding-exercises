/**
 * Created by Nelson on 2019/7/24.
 */

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归
        assert( p != null && q != null );
        // 递归终止条件
        if( root == null )
            return null;

        // 递归过程
        // 如果p和q都在左侧
        if( Math.max(p.val, q.val) < root.val ) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // 如果p和q都在右侧
        if( Math.min(p.val, q.val) > root.val ) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // 当p和q在root两侧时，返回root
        return root;
    }
}
