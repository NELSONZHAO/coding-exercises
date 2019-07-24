/**
 * Created by Nelson on 2019/7/24.
 */

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 这个题和235是类似的题，只不过这个更加一般化为普通的Binary Tree
 */
public class LowestCommonAncestorBT {

    public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q ) {
        // 递归
        assert( p != null && q != null );

        // 递归结束条件
        if( root == null )
            return null;

        // 递归过程
        // 情况1：如果root等于其中某一个结点值，且root子树包含另一个结点，则此时root就是LCA
        if( (root.val == p.val && containsNode(root, q)) || (root.val == q.val && containsNode(root, p)) )
            return root;

        // 情况2：如果p和q在root的同一侧，递归调用该函数
        if( containsNode(root.left, p) && containsNode(root.left, q) )
            return lowestCommonAncestor(root.left, p, q);

        if( containsNode(root.right, p) && containsNode(root.right, q) )
            return lowestCommonAncestor(root.right, p, q);

        // 情况3：p和q在root两侧，此时root就是根节点
        return root;
    }

    /**
     * 给定以root为根节点的tree，判断是否包含node结点
     * @param root
     * @param node
     * @return
     */
    private boolean containsNode(TreeNode root, TreeNode node) {
        //
        assert( node != null );

        // 递归结束条件
        if( root == null )
            return false;

        if( root.val == node.val )
            return true;

        // 递归过程
        return containsNode(root.left, node) || containsNode(root.right, node);
    }
}
