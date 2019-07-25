/**
 * Created by Nelson on 2019/7/25.
 */

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBST {

    public TreeNode convertToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        // 递归结束条件
        if( l > r )
            return null;

        int mid = l + ( r - l ) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, l, mid-1);
        root.right = helper(nums, mid+1, r);

        return root;
    }
}
