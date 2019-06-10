/**
 * Created by Nelson on 2019/6/10.
 */

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 */

import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 思路：查找表
        // 遍历每一个字符串，统计各个字符出现次数
        // 去查找表中查找是否存在，如果存在则加入相应的结果中

        List<List<String>> ret = new ArrayList<>();

        if( strs.length == 0 )
            return ret;

        // 构建查找表，其中key是字符串排序后的结果，value是list
        Map<String, List> hashMap = new HashMap<>();

        for( int i = 0; i < strs.length; i++ ) {
            // 对当前字符串排序
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 查找是否包含这个元素
            if( !hashMap.containsKey(key) ) {
                hashMap.put(key, new ArrayList());
            }

            hashMap.get(key).add(strs[i]);

        }

        // 整理结果
        for( String key : hashMap.keySet() ) {
            ret.add(hashMap.get(key));
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams solution = new GroupAnagrams();
        List<List<String>> ret = solution.groupAnagrams(strs);

        for( int i = 0; i < ret.size(); i++ ) {
            for( String s : ret.get(i) ) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
