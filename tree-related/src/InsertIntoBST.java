/**
 * Created by Nelson on 2019/4/9.
 */

/**
 * 701. Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */

public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 思路：递归插入

        // 递归结果
        if( root == null || root.val == val )
            return new TreeNode(val);

        // 递归过程
        if( val < root.val ) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        // 测试用例
        Tree tree = new Tree();
        Integer[] arr = new Integer[]{4, 2, 7, 1, 3};
        int val = 5;
        TreeNode root = tree.createTree(arr);

        System.out.println("Before insertion: ");
        tree.traverseTree(root);

        System.out.println("After insertion: ");
        InsertIntoBST solution = new InsertIntoBST();
        tree.traverseTree(solution.insertIntoBST(root, val));
    }
}
