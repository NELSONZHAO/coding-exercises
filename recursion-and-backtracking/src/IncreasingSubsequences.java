/**
 * Created by Nelson on 2020/1/12.
 */

import java.util.*;

// 思路：回溯法
class IncreasingSubsequences {

    List<List<Integer>> ret = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums){
        helper(new LinkedList<>(), nums, 0);

        return ret;
    }

    private void helper(List<Integer> list, int[] nums, int index) {
        if( list.size() > 1 ) {
            ret.add(new LinkedList<Integer>(list));
        }

        Set<Integer> visited = new HashSet<>();
        for( int i = index; i < nums.length; i++ ) {
            if( visited.contains(nums[i]) ) {
                continue;
            }
            if( list.size() == 0 || nums[i] >= list.get(list.size()-1) ) {
                visited.add(nums[i]);
                list.add(nums[i]);
                helper(list, nums, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 7, 7};
        IncreasingSubsequences solution = new IncreasingSubsequences();
        List<List<Integer>> ret = solution.findSubsequences(arr);

        for( List<Integer> list : ret ) {
            for( Integer n : list ) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
