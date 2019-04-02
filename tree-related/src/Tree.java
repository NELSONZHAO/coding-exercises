/**
 * Created by Nelson on 2019/4/2.
 */

import java.util.*;

// 树结点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {

    TreeNode root;

    public TreeNode createTree(Integer[] arr) {
        // 根据数组生成tree
        int n = arr.length;
        if( n == 0 )
            return null;

        // 构造树
        root = createTree(arr, 0);

        return root;
    }

    private TreeNode createTree(Integer[] arr, int index) {
        // 递归地对数组arr的部分构建tree
        // 对于一个数组元素，其左孩子是2*i+1，右孩子是2*i+2

        // 递归终止条件
        if( index >= arr.length )
            return null;

        // 递归过程
        if( arr[index] == null )
            return null;

        TreeNode node = new TreeNode(arr[index]);
        node.left = createTree(arr, 2*index+1);
        node.right = createTree(arr, 2*index+2);

        return node;
    }

    public void traverseTree(TreeNode root) {
        // 广度优先遍历树
        if( root == null )
            return;

        // 使用队列
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while( !queue.isEmpty() ) {
            int size = queue.size();

            for( int i = 0; i < size; i++ ) {
                TreeNode node = queue.poll();
                System.out.println(node.val);

                if( node.left != null )
                    queue.offer(node.left);
                if( node.right != null )
                    queue.offer(node.right);

            }
        }
    }

    public static void main(String[] args) {
        // 测试用例
        Integer[] arr = new Integer[]{1, 2, 3, 4, null, null, 5};
        Tree tree =  new Tree();
        TreeNode root = tree.createTree(arr);

        // BFS树
        tree.traverseTree(root);
    }
}
