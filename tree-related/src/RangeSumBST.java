/**
 * Created by Nelson on 2019/4/2.
 */

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        // 思路：递归求解，利用二叉搜索树的性质做二分查找

        // 递归终止条件
        if( root == null )
            return 0;

        // 递归过程
        // 1.下界比当前val大，则去右子树搜索
        if( L > root.val ) {
            return rangeSumBST(root.right, L, R);
        }
        // 2. 上界比当前val小，则去左子树搜索
        else if( R < root.val ) {
            return rangeSumBST(root.left, L, R);
        }
        // 3. 否则，在左子树搜索[L...root.val) + 在右子树搜索(root.val, R] + root.val
        else {
            return root.val + rangeSumBST(root.left, L, root.val-1) + rangeSumBST(root.right, root.val+1, R);
        }
    }

    public static void main(String[] args) {
        // 测试用例
        Integer[] arr = new Integer[]{10, 5, 15, 3, 7, 13, 18, 1, null, 6};
        // 生成树
        Tree tree = new Tree();
        TreeNode root = tree.createTree(arr);

        RangeSumBST solution = new RangeSumBST();
        int ret = solution.rangeSumBST(root, 6, 10);
        // 输出
        System.out.println(ret);
    }
}
