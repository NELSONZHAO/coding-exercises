/**
 * Created by Nelson on 2019/8/10.
 */

/**
 * 给定义棵二叉搜索树，转化为双向链表
 */
public class ConvertBSTToDeque {

    public TreeNode convert(TreeNode root) {
        // 递归结束
        if( root == null )
            return null;

        if( root.left == null && root.right == null )
            return root;

        // 递归过程
        // 转换左边
        TreeNode left = convert(root);
        TreeNode p = left;

        // 找到尾部结点
        while( p != null && p.right != null ) {
            p = p.right;
        }

        if( left != null ) {
            root.left = p;
            p.right = root;
        }

        // 转换右边
        TreeNode right = convert(root);
        if( right != null ) {
            right.left = root;
            root.right = right;
        }

        return left != null ? left : root;
    }
}
