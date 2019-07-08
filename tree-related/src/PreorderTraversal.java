/**
 * Created by Nelson on 2019/7/8.
 */

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 二叉树的先序遍历
 */

import java.util.*;
public class PreorderTraversal {

    // 方法1：递归方法
    public List<Integer> preorderTraversal( TreeNode root ) {
        List<Integer> ret = new ArrayList<>();

        // 递归结束条件
        if( root == null ) {
            return ret;
        }

        // 递归过程
        ret.add(root.val);
        ret.addAll(preorderTraversal(root.left));
        ret.addAll(preorderTraversal(root.right));

        return ret;
    }

    // 方法2：非递归算法
}
