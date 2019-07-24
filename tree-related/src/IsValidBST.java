/**
 * Created by Nelson on 2019/7/24.
 */

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {

    // 思路1：利用上下界(L,R)来确定
    public boolean isValidBST(TreeNode root) {
        // 递归函数
        // BST的条件：左右子树均为BST且左子树最大值小于root.val 且 右子树最小值 > root.val
        if( root == null )
            return true;

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long L, long R) {
        // 递归：给定(L,R)区间，判断以root为根节点的BT是否是BST
        if( root == null )
            return true;

        if( root.val <= L || root.val >= R )
            return false;

        return helper(root.left, L, root.val) && helper(root.right, root.val, R);
    }

    // 思路2：构造两个大小值判断函数解
}
