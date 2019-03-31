/**
 * Created by Nelson on 2019/3/31.
 */

/**
 * 929. Unique Email Addresses
 * https://leetcode.com/problems/unique-email-addresses/
 */

import java.util.*;
public class NumUniqueEmails {

    public int numUniqueEmails(String[] emails) {
        // 思路：字符替换 + Set
        int n = emails.length;
        if( n == 0 )
            return 0;

        // 构建hashSet
        Set<String> hashSet = new HashSet<String>();

        // 遍历emails并求解
        for( int i = 0; i < n; i++ ) {
            String[] emailParts = emails[i].split("\\@");
            String local = emailParts[0];
            if( local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }

            local = local.replaceAll("\\.", "");

            hashSet.add(local + emailParts[1]);
        }

        return hashSet.size();
    }

    public static void main(String[] args) {
        // 测试用例
        String[] emails = new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};

        NumUniqueEmails solution = new NumUniqueEmails();
        System.out.println(solution.numUniqueEmails(emails));
    }
}
