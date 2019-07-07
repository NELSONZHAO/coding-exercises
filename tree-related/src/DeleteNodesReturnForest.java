/**
 * Created by Nelson on 2019/7/7.
 */

/**
 * 1110. Delete Nodes And Return Forest
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */

import java.util.*;
public class DeleteNodesReturnForest {

    // 待删除元素值的集合
    Set<Integer> hashSet;
    // 返回Forest头结点集合
    List<TreeNode> ret;

    public List<TreeNode> delNodes( TreeNode root, int[] toDelete ) {
        // 思路：递归

        ret = new ArrayList<>();

        if( root == null )
            return ret;

        // 将待删除元素转为集合
        hashSet = new HashSet<>();
        for( int del : toDelete ) {
            hashSet.add(del);
        }

        // 调用递归函数
        helper(root, true);

        return ret;
    }

    /**
     * 给定一颗树中的结点，以及该结点是否为根节点的信息。返回删除待删除元素后的
     * @param node
     * @param isRoot
     * @return
     */
    private TreeNode helper( TreeNode node, boolean isRoot ) {
        // 递归函数

        // 递归结束条件
        if( node == null )
            return null;

        // 判断当前结点是否需要纳入结果森林中
        // 纳入森林需要满足两个条件：1.是头结点；2.不在删除列表中
        boolean isDeleted = hashSet.contains(node.val);

        if( isRoot && !isDeleted ) {
            ret.add(node);
        }

        // 递归下去
        // isDelete代表node的子节点是否为根节点：
        // 1.当isDelete=true时，node被删除，则左右孩子变为新的根节点
        // 2.否则，左右孩子不是根节点
        node.left = helper(node.left, isDeleted);
        node.right = helper(node.right, isDeleted);

        return isDeleted ? null : node;
    }

    public static void main(String[] args) {
        // 测试用例
        Tree tree = new Tree();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = tree.createTree(arr);

        int[] toDelete = new int[]{3, 5};

        DeleteNodesReturnForest solution = new DeleteNodesReturnForest();
        List<TreeNode> ret = solution.delNodes(root, toDelete);

        for( TreeNode node : ret ) {
            System.out.println(node.val);
        }
    }
}
