/**
 * Created by Nelson on 2019/5/8.
 */

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */

import java.util.*;
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        // 思路：构建查找表
        int len1 = nums1.length;
        int len2 = nums2.length;

        if( len1 == 0 || len2 == 0 )
            return new int[]{};

        Set<Integer> set = new HashSet<>();

        // 遍历nums1构建查找表
        for( int e : nums1 )
            set.add(e);

        List<Integer> interSet = new ArrayList<>();
        // 遍历nums2去判断元素
        for( int e : nums2 ) {
            if( set.contains(e) ) {
                interSet.add(e);
                set.remove(e);
            }
        }

        int[] ret = new int[interSet.size()];

        for( int i = 0; i < interSet.size(); i++ ) {
            ret[i] = interSet.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums1 = new int[]{1, 2, 2, 4, 6, 7};
        int[] nums2 = new int[]{2, 6, 7, 4};

        Intersection solution = new Intersection();
        int[] ret = solution.intersection(nums1, nums2);
        for( int e : ret )
            System.out.println(e);
    }
}
