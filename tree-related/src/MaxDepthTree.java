/**
 * Created by Nelson on 2019/7/16.
 */
public class MaxDepthTree {

    public int maxDepth(TreeNode root) {
        // 递归
        // 递归结束条件
        if( root == null )
            return 0;

        // 递归过程
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
