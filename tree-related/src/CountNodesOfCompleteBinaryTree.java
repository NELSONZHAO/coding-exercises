/**
 * Created by Nelson on 2019/7/18.
 */

/**
 * 222. Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountNodesOfCompleteBinaryTree {

    public int countNodes( TreeNode root ) {
        // 完全二叉树的子树也是完全二叉树

        if( root == null )
            return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
