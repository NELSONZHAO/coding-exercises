/**
 * Created by Nelson on 2019/2/24.
 */

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 */

import java.util.*;

public class Permutations {

    private List<List<Integer>> ret = new LinkedList<>();
    private boolean[] visited;

    // p中保存了有index个元素的排列
    // 向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
    private void findPermutations(int[] nums, int index, LinkedList<Integer> p) {
        // 递归结束条件
        if( index == nums.length ) {
            // 此时找到一个排列的结果
            ret.add((LinkedList<Integer>)p.clone());
            return;
        }

        for( int i = 0; i < nums.length; i++) {
            if( !visited[i] ) {
                p.addLast(nums[i]);
                visited[i] = true;
                findPermutations(nums, index + 1, p);
                p.removeLast();
                visited[i] = false;
            }
        }

        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        if( nums.length == 0 )
            return ret;

        visited = new boolean[nums.length];

        findPermutations(nums, 0, new LinkedList<>());

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        Permutations solution = new Permutations();
        List<List<Integer>> res = solution.permute(nums);

        for( int i = 0; i < res.size(); i++ ) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }
    }
}
