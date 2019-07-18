/**
 * Created by Nelson on 2019/7/18.
 */

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class IsBalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        // 思路：递归
        // 满足条件：1.左子树平衡，右子树平衡，左右子树高度之差绝对值<=1
        // 递归结束条件
        if( root == null )
            return true;

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
