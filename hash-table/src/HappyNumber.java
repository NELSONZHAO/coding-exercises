/**
 * Created by Nelson on 2019/3/11.
 */

import java.util.*;
/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 */

public class HappyNumber {

    public boolean isHappyNumber(int n) {
        // 思路：查找表
        // 时间复杂度：-
        // 空间复杂度：-

        if( n <= 0 )
            throw new IllegalArgumentException();

        Set<Integer> set = new HashSet<>();

        while( n != 1 ) {

            if( set.contains(n) )
                return false;

            set.add(n);

            n = getNext(n);
        }

        return true;
    }

    private int getNext(int num) {
        int ret = 0;

        while( num != 0 ) {
            int i = num % 10;
            ret += i * i;

            num /= 10;
        }

        return ret;
    }

    public static void main(String[] args) {
        // 测试用例
        int num = 19;

        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappyNumber(num));
    }
}
