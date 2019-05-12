/**
 * Created by Nelson on 2019/5/12.
 */

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */

import java.util.*;
public class IntersectionII {

    public int[] intersect(int[] nums1, int[] nums2) {
        // 思路：构建Map
        int len1 = nums1.length;
        int len2 = nums2.length;

        if( len1 == 0 || len2 == 0 )
            return new int[]{};

        // 对nums1构建hash-map
        Map<Integer, Integer> hashMap = new HashMap<>();
        for( int e : nums1 ) {
            hashMap.put( e, hashMap.getOrDefault(e, 0) + 1 );
        }

        // 返回值
        List<Integer> ret = new ArrayList<>();

        // 遍历nums2
        for( int i = 0; i < len2; i++ ) {
            int e = nums2[i];
            if( hashMap.getOrDefault(e, 0) > 0 ) {
                ret.add(e);
                hashMap.put(e, hashMap.get(e) - 1 );
            }
        }

        //
        int[] res = new int[ret.size()];

        for( int i = 0; i < ret.size(); i++ ) {
            res[i] = ret.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2, 3};

        IntersectionII solution = new IntersectionII();
        int[] ret = solution.intersect(nums1, nums2);

        for( int e : ret )
            System.out.println(e);
    }
}
