/**
 * Created by Nelson on 2019/7/23.
 */

/**
 * 437. Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {

    public int pathSum( TreeNode root, int sum ) {
        // 递归嵌套
        if( root == null )
            return 0;

        //
        int res = 0;

        // 当root在路径上时
        res += helper(root, sum);
        // 当root不在路径上时
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    private int helper(TreeNode node, int sum) {
        if( node == null )
            return 0;

        // 判断当前
        int res = 0;
        if( node.val == sum )
            res += 1;

        // 递归
        res += helper(node.left, sum - node.val);
        res += helper(node.right, sum - node.val);

        return res;
    }
}
