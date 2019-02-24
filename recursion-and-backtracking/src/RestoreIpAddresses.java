/**
 * Created by Nelson on 2019/2/24.
 */

/**
 * 93. Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 */

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

public class RestoreIpAddresses {

    private List<String> ret = new LinkedList<>();

    private boolean isIpValid(String ip) {
        /**
         * 判断给定ip地址是否合法
         */
        if( ip.equals("") )
            return false;

        if( ip.substring(0, 1).equals("0") && ip.length() > 1 )
            return false;

        int ipInt = Integer.parseInt(ip);
        if( ipInt > 255 || ipInt < 0 )
            return false;

        return true;
    }

    private void findSolution(String s, String part, int level) {
        /**
         * s为字符串还未处理的部分
         * part为当前已经处理过的一个ip的部分
         * level为当前处理的ip为第几段。一个ip共分为4段
         */

        // 递归终止条件
        if( s.equals("") && level == 5 ) {
            ret.add(part.substring(1)); // 剔除开头的"."
            return;
        }

        // 当前处理的为最后一段
        if( level == 4 ) {
            if( isIpValid(s) )
                findSolution("", part + "." + s, level + 1);
            return;
        }

        // 否则
        for( int i = 0; i < Math.min(3, s.length()); i++ ) {
            String subStr = s.substring(0, i + 1);
            // 判断当前截取的部分是否合法
            if( isIpValid(subStr) )
                findSolution(s.substring(i+1), part + "." + subStr, level + 1);
            else
                continue;
        }

        return;
    }

    public List<String> restoreIpAddresses(String s) {
        // 思路：回溯法
        if( s.equals("") || s.length() > 12 )
            return ret;

        findSolution(s, "", 1);
        return ret;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIpAddresses solution = new RestoreIpAddresses();
        List<String> res = solution.restoreIpAddresses(s);

        for( int i = 0; i < res.size(); i++ )
            System.out.println(res.get(i));
    }
}
