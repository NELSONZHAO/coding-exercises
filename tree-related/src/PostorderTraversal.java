/**
 * Created by Nelson on 2019/7/8.
 */

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

import java.util.*;
public class PostorderTraversal {

    // 方法1：递归方法
    public List<Integer> postorderTraversal( TreeNode root ) {
        // 递归
        List<Integer> ret = new ArrayList<>();

        // 递归结束
        if( root == null ) {
            return ret;
        }

        // 递归过程
        ret.addAll(postorderTraversal(root.left));
        ret.addAll(postorderTraversal(root.right));
        ret.add(root.val);

        return ret;
    }
}
