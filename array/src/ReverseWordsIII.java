/**
 * Created by Nelson on 2020/1/13.
 */
public class ReverseWordsIII {
    public String reverseWords(String s) {
        // 对撞指针
        if( s.equals("") )
            return s;

        char[] chars = s.toCharArray();

        int i = 0;
        int j = 0;

        while( i < chars.length  && j < chars.length ) {
            while( i < chars.length && chars[i] == ' ' ) {
                i++;
            }

            while( j < chars.length && chars[j] != ' ' ) {
                j++;
            }

            int p = j-1;
            // 交换从[i...j-1]区间的元素
            while( i < p ) {
                char temp = chars[i];
                chars[i] = chars[p];
                chars[p] = temp;
                i++;
                p--;
            }

            i = j + 1;
            j = i;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWordsIII solution = new ReverseWordsIII();
        String ret = solution.reverseWords(s);
        System.out.println(ret);
    }
}
