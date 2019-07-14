/**
 * Created by Nelson on 2019/7/14.
 */
public class LCADeepestLeaves {

    public TreeNode lcaDeepestLeaves( TreeNode root ) {
        // Recursion

        // The termination of recursion
        if( root.left == null && root.right == null )
            return root;


        // The procedure of recursion

        // 1. if the depth of left node is strictly larger than the right node
        // we only need to consider the left one
        if( depth(root.left) > depth(root.right) ) {
            return lcaDeepestLeaves(root.left);
        }
        // 2. if the depth of left node is strictly less than the right node
        // we only need to consider the right one
        else if( depth(root.left) < depth( root.right) ) {
            return lcaDeepestLeaves(root.right);
        }
        // 3. if the depth of left node and right node are equal
        // we have to judge whether the root.left and root.right are the same
        else {
            // root.left and root.right are not null
            if( root.left != null && root.right != null ) {
                return root.left == root.right ? root.left : root;
            }

            // if one is not null, return that one (since we have already process the leaf node at the start of this function）
            return root.left != null ? root.left : root.right;
        }
    }

    private int depth( TreeNode node ) {
        // Recursion

        // The termination of recursion
        if( node == null )
            return 0;

        return Math.max( depth(node.left), depth(node.right) ) + 1;
    }

    public static void main( String[] args ) {
        // 测试用例
        Tree tree = new Tree();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        TreeNode root = tree.createTree(arr);

        LCADeepestLeaves solution = new LCADeepestLeaves();
        TreeNode node = solution.lcaDeepestLeaves(root);

        tree.traverseTree(node);
    }
}
