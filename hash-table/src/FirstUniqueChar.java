/**
 * Created by Nelson on 2019/6/16.
 */
public class FirstUniqueChar {

    public int firstUniqueChar(String s) {
        // 思路：查找表
        // 统计每个字符出现的次数
        // 遍历字符串，返回第一次出现次数为1的索引
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)

        char[] chars = s.toCharArray();
        int[] set = new int[26];
        int ret = -1;

        // 统计字符频次
        for( char c : chars ) {
            set[c-'a']++;
        }

        // 遍历
        for( int i = 0; i < chars.length; i++ ) {
            if( set[chars[i]-'a'] == 1 )
                return i;
        }

        return ret;
    }

    public static void main( String[] args ) {
        // 测试用例
        String s = "leetcode";
        FirstUniqueChar solution = new FirstUniqueChar();
        System.out.println(solution.firstUniqueChar(s));
    }
}
