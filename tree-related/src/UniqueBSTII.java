/**
 * Created by Nelson on 2019/4/10.
 */

/**
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */

import java.util.*;

public class UniqueBSTII {

    public List<TreeNode> generateTrees(int n) {
        // 思路：递归求解
        if( n == 0 )
            return new ArrayList<>();

        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        // 功能：给定区间[start...end]，返回所有满足条件的BST

        List<TreeNode> ret = new ArrayList<>();

        // 递归结束条件
        if( start > end ) {
            ret.add(null);
            return ret;
        }

        // 递归过程
        // 以区间中每个值i为root
        for( int i = start; i <= end; i++ ) {
            // 递归
            List<TreeNode> leftParts = helper(start, i-1);
            List<TreeNode> rightParts = helper(i+1, end);

            // 对左右两边子树做笛卡尔积
            for( TreeNode left : leftParts ) {
                for( TreeNode right : rightParts ) {
                    // 创建根节点
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;

                    // 添加一个解
                    ret.add(root);
                }
            }
        }

        return ret;

    }

    public static void main(String[] args) {
        // 测试用例
        int n = 3;

        UniqueBSTII solution = new UniqueBSTII();
        List<TreeNode> ret = solution.generateTrees(n);

        Tree tree = new Tree();

        for( int i = 0; i < ret.size(); i++ ) {
            System.out.println("The " + (i+1) + " solution: ");
            tree.traverseTree(ret.get(i));
        }
    }
}
