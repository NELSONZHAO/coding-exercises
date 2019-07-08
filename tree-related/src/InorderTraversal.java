/**
 * Created by Nelson on 2019/7/8.
 */

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

import java.util.*;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
        List<Integer> ret = new ArrayList<>();

        // 递归结束条件
        if( root == null ) {
            return ret;
        }

        // 递归过程
        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));

        return ret;
    }
}
