/**
 * Created by Nelson on 2019/8/3.
 */

/**
 *
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 思路：动态规划
        // 定义状态：f(i)代表s[0...i]字符串是否能被wordDict中元素表示
        // 状态转移：f(i) = f(j) && wordDict.contains(s.substr(j...i)) for 0 <= j <= i;

        int len = s.length();
        boolean[] dp = new boolean[len];
        Arrays.fill(dp, false);

        // 把wordDict转成set
        if (wordDict.size() == 0)
            return false;

        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        // 动态规划
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                // 取出[j...i]的元素，判断是否包含
                String subStr = s.substring(j, i + 1);
                dp[i] = dp[i] || (j-1 >= 0 ? dp[j-1] && set.contains(subStr):set.contains(subStr));
            }
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        // 测试用例
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
