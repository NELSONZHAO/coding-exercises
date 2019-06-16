/**
 * Created by Nelson on 2019/6/16.
 */

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
import java.util.*;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 思路：查找表
        // 维持一个长度为 k + 1 长度（变化后）的set查找表，对新的待考虑元素进行查找，若在查找表中存在，返回结果；
        // 否则，纳入该元素，并左移指针，考虑新的元素
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)
        int len = nums.length;
        if( len <= 1 )
            return false;

        // 定义查找表
        Set<Integer> set = new HashSet<>();
        // 遍历元素
        for( int i = 0; i < len; i++ ) {
            // i为待考虑元素
            if( set.contains(nums[i]) ) {
                return true;
            }

            set.add(nums[i]);

            // 如果窗口长度超过
            if( set.size() == k + 1 ) {
                set.remove(nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3;

        ContainsNearbyDuplicate solution = new ContainsNearbyDuplicate();
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}
