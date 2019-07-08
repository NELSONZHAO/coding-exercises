/**
 * Created by Nelson on 2019/7/8.
 */

/**
 * 剑指offer题
 * 根据二叉树的先序遍历结果pre和中序遍历结果in来reconstruct树
 * 其中树中元素是唯一的（不存在重复值）
 */
public class ReconstructTreeFromPreAndIn {

    public TreeNode reconstructTree( int[] prev, int[] in ) {
        // 思路：递归
        // 注意几个性质：
        // 二叉树先序遍历的第一个值为根节点
        // 找到根节点之后，在中序遍历中寻找左子树的结点和右子树的结点个数
        // 再去先序遍历拿出左子树和右子树的元素，进行递归

        assert( prev.length == in.length );

        int n = prev.length;

        TreeNode root = helper(prev, 0, n-1, in, 0, n-1);

        return root;
    }

    /**
     * 给定prev[pl...pr]先序遍历结果 和 in[il...ir]中序遍历结果，重建树
     * @param prev
     * @param pl
     * @param pr
     * @param in
     * @param il
     * @param ir
     * @return
     */
    private TreeNode helper(int[] prev, int pl, int pr, int[] in, int il, int ir) {
        // 递归

        // 递归结束条件
        if( pl > pr || il > ir ) {
            return null;
        }

        // 递归过程
        // 找到根节点
        int rootVal = prev[pl];
        TreeNode root = new TreeNode(rootVal);

        // 从中序遍历中找到根节点位置，确定左右子树的个数
        int i = 0;
        for( ;i <= pr; i++ ) {
            if( in[i] == rootVal ) {
                break;
            }
        }

        // 此时i指向根节点
        // 计算左子树的结点数
        int leftTreeLen = i - il;

        // 构造子树
        root.left = helper(prev, pl+1, pl+leftTreeLen, in, il, i-1 );
        root.right = helper(prev, pl+leftTreeLen+1, pr, in, i+1, ir);

        return root;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] prev = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in  = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        ReconstructTreeFromPreAndIn solution = new ReconstructTreeFromPreAndIn();
        TreeNode root = solution.reconstructTree(prev, in);

        Tree tree = new Tree();
        tree.traverseTree(root);
    }
}
