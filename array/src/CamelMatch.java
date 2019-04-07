/**
 * Created by Nelson on 2019/4/7.
 */

/**
 * 1023. Camelcase Matching
 * https://leetcode.com/problems/camelcase-matching/
 */
import java.util.*;
public class CamelMatch {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        // 思路：对于query中每个元素与pattern进行对比，利用两个指针移动比较
        List<Boolean> ret = new ArrayList<>();

        if( queries.length == 0 || pattern.equals("") )
            return ret;

        for( int i = 0; i < queries.length; i++ ) {
            String query = queries[i];
            ret.add( helper(query, pattern) );
        }

        return ret;
    }

    private boolean helper(String query, String pattern) {
        // 判断query是否符合pattern，返回boolean
        int i = 0;
        int j = 0;

        while( i < query.length() && j < pattern.length() ) {
            // 取出当前指针对应的字符
            char qc = query.charAt(i);
            char pc = pattern.charAt(j);

            // 判断字符是否相同
            // 如果相同，则移动两个指针
            if( qc == pc ) {
                i++;
                j++;
            } else { // 如果不相同，判断大小写
                if( Character.isUpperCase(qc) ){
                    // 如果是大写，则不满足当前pattern，返回false
                    return false;
                } else {
                    // 如果是小写，则移动i指针
                    i++;
                }

            }
        }

        // 判断当前query剩余是否还有大写字母
        for( ; i < query.length(); i++ ) {
            if( Character.isUpperCase(query.charAt(i)) )
                return false;
        }

        return j == pattern.length();
    }

    public static void main(String[] args) {
        // 测试用例
        String[] queries = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";

        CamelMatch solution = new CamelMatch();
        List<Boolean> ret = solution.camelMatch(queries, pattern);

        for( Boolean r : ret ) {
            System.out.println(r);
        }
    }
}
