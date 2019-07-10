/**
 * Created by Nelson on 2019/7/10.
 */

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 这个题返回结果是一个二维链表，也就是每一层是一个子链表，因此需要去标注当前元素的层序
 * 相关题目：107 103
 */

import java.util.*;
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        // 思路：使用队列
        List<List<Integer>> ret = new ArrayList<>();

        if( root == null )
            return ret;

        // 使用队列进行BFS
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while( !q.isEmpty() ) {
            // 当前队列中的元素一定在一层，统计有几个
            int levelLen = q.size();

            // 每一层的子链表
            List<Integer> subList = new ArrayList<>();

            // 遍历每个元素
            for( int i = 0; i < levelLen; i++ ) {
                TreeNode node = q.poll();

                subList.add(node.val);

                // 入队当前结点的左右孩子
                if( node.left != null )
                    q.offer(node.left);

                if( node.right != null )
                    q.offer(node.right);
            }

            // 加入总链表
            ret.add(subList);
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        Tree tree = new Tree();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, null, 7};

        TreeNode root = tree.createTree(arr);

        LevelOrderTraversal solution = new LevelOrderTraversal();
        List<List<Integer>> ret = solution.levelOrderTraversal(root);

        for( int i = 0; i < ret.size(); i++ ) {
            for( int j = 0; j < ret.get(i).size(); j++ ) {
                System.out.print(ret.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
