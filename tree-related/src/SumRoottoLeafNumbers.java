/**
 * Created by Nelson on 2019/7/20.
 */

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {

        return helper(root, 0);
    }

    /**
     * 递归函数：给定树节点node，与截止其父亲节点的路径之和，求到根节点的路径之和
     * @param node
     * @param s
     * @return
     */
    private int helper(TreeNode node, int s ) {
        // 递归
        // 递归结束条件
        if( node == null )
            return 0;

        if( node.left == null && node.right == null )
            return s * 10 + node.val;

        // 递归过程
        return helper(node.left, s * 10 + node.val) + helper(node.right, s * 10 + node.val);
    }

    public static void main(String[] args) {
        // 测试用例
        Integer[] arr = new Integer[]{1,2,3};
        Tree tree = new Tree();
        TreeNode root = tree.createTree(arr);

        SumRoottoLeafNumbers solution = new SumRoottoLeafNumbers();
        System.out.println(solution.sumNumbers(root));
    }
}
