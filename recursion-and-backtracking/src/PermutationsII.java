/**
 * Created by Nelson on 2019/8/7.
 */

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 * 有重复元素
 */

import java.util.*;
public class PermutationsII {

    List<List<Integer>> res = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        // 由于考虑不允许出现重复排列，则首先需要对nums进行排序，在后续可以进行重复剔除
        if( nums.length == 0 )
            return res;

        Arrays.sort(nums);
        visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        helper(nums, 0, new LinkedList<Integer>() );

        return res ;
    }

    /**
     * 给定nums中元素，在p中含有capacity个元素的情况下，考虑第capacity+1个元素加入排列
     * @param nums
     * @param capacity
     * @param p
     */
    private void helper(int[] nums, int capacity, LinkedList<Integer> p) {
        // 递归
        if( capacity == nums.length ) {
            res.add( (LinkedList<Integer>)p.clone() );
            return;
        }

        // 递归过程
        for( int i = 0; i < nums.length; i++ ) {
            // 提出重复项
            if( i > 0 && nums[i] == nums[i-1] && !visited[i-1] )
                continue;

            if( !visited[i] ) {
                p.addLast(nums[i]);
                visited[i] = true;
                helper(nums, capacity + 1, p);
                p.removeLast();
                visited[i] = false;
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};

        PermutationsII solution = new PermutationsII();
        List<List<Integer>> res = solution.permute(nums);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }
    }
}
