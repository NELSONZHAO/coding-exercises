/**
 * Created by Nelson on 2019/4/10.
 */

/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBST {

    public int numTrees( int n ) {
        // 思路：动态规划
        // 定义状态：F(i, n)代表n个有序结点，以i为root的BST个数
        // 最终解G(n) = F(1, n) + F(2, n) + ... + F(n, n);
        // F(i, n) = G(i-1) * G(n-i)  以i为根节点，左侧有i-1个有序结点，右侧有n-i个有序结点
        // 注意G(6)代表6个有序结点，1-6和4-9组成的BST个数是一样的
        // 结合上述公式，可得到G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ... + G(n) * G(0);

        if( n == 0 )
            return 0;

        // 创建数组
        int[] memo = new int[n+1];
        memo[0] = 1;
        memo[1] = 1;

        for( int i = 2; i <= n; i++ ) {
            for( int j = 1; j <= i; j++ )
            memo[i] += memo[j-1] * memo[i-j];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        // 测试用例
        int n = 3;
        UniqueBST solution = new UniqueBST();
        System.out.println(solution.numTrees(n));
    }
}
