/**
 * Created by Nelson on 2019/7/16.
 */

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {

    // 思路1：递归套递归
    // 当前node的最大DBT = max{经过当前node的路径，经过当前node左孩子的路径，经过当前node右孩子的路径}
    public int diameterOfBinaryTree( TreeNode root ) {
        // 递归终止条件
        if( root == null )
            return 0;

        // 递归过程
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int diameter = maxDepth(root.left) + maxDepth(root.right);

        return Math.max( diameter, Math.max(leftDiameter, rightDiameter));
    }

    private int maxDepth( TreeNode root ) {
        if( root == null )
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    // 思路2：递归+全局变量
    int res = 0;
    public int diameterOfBinaryTree2( TreeNode root ) {
        maxDepth2(root);

        return res;
    }

    private int maxDepth2( TreeNode root ) {
        if( root == null )
            return 0;

        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);

        // 更新res
        res = Math.max( res, leftDepth + rightDepth );

        return Math.max( leftDepth, rightDepth ) + 1;
    }
}
