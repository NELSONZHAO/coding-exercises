/**
 * Created by Nelson on 2019/7/16.
 */

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public TreeNode invertBinaryTree( TreeNode root ) {
        // 递归

        // 递归结束条件
        if( root == null )
            return null;

        // 递归过程
        TreeNode leftTree = root.left;

        // 翻转
        root.left = invertBinaryTree(root.right);
        root.right = invertBinaryTree(leftTree);

        return root;
    }
}
