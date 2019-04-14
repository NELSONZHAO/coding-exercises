/**
 * Created by Nelson on 2019/4/14.
 */

/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class MaxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {
        // 思路：递归求解
        if( root == null )
            return 0;

        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode node, int min, int max) {
        // 功能：给定树结点node，以及当前找到的整棵树的最小值与最大值，返回最大diff

        // 递归结束条件
        if( node == null ) {
            return 0;
        }

        // 更新min和max值
        min = Math.min(node.val, min);
        max = Math.max(node.val, max);

        // 递归
        int l = helper(node.left, min, max);
        int r = helper(node.right, min, max);

        return Math.max( max-min, Math.max( l, r ) );
    }

    public static void main(String[] args) {
        // 测试用例
        Tree tree = new Tree();
        Integer[] arr = new Integer[]{8,3,10,1,6,null,14,null,null,4,7,13};
        TreeNode root = tree.createTree(arr);

        MaxAncestorDiff solution = new MaxAncestorDiff();
        System.out.println(solution.maxAncestorDiff(root));
    }
}
