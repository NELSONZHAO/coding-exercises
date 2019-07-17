/**
 * Created by Nelson on 2019/7/17.
 */

/**
 * 669. Trim a Binary Search Tree
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class TrimBST {

     public TreeNode trimBST(TreeNode root, int L, int R) {
         // 递归
         // 递归结束条件
         if( root == null )
             return null;

         if( root.val < L )
             return trimBST(root.right, L, R);

         if( root.val > R )
             return trimBST(root.left, L, R);

         // 递归过程
         root.left = trimBST(root.left, L, R);
         root.right = trimBST(root.right, L, R);

         return root;
     }
}
