/**
 * Created by Nelson on 2019/4/7.
 */

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        // 思路：递归求解
        // 时间复杂度：O(n)
        // 空间复杂度：O(logn)
        return helper(root, 0);
    }

    private int helper(TreeNode root, int val) {
        // 递归结束条件
        if( root == null )
            return 0;

        // 递归过程
        // 父节点求的和 + 当前结点值
        val = val * 2 + root.val;
        // 当前结点为叶子结点，则直接返回val
        if( root.left == null && root.right == null )
            return val;
        // 否则，继续递归求解
        return helper(root.left, val) + helper(root.right, val);
    }

    public static void main(String[] args) {
        // 测试用例
        Tree tree = new Tree();
        Integer[] arr = new Integer[]{1, 0, 1, 0, 1, 0, 1};
        TreeNode root = tree.createTree(arr);

        SumRootToLeaf solution = new SumRootToLeaf();
        System.out.println(solution.sumRootToLeaf(root));
    }
}
