/**
 * Created by Nelson on 2019/7/13.
 */
import java.util.*;

class Pair {
    String word;
    int step;
    public Pair( String word, int step ) {
        this.word = word;
        this.step = step;
    }
}

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 图论
        // 图的广度优先遍历
        // 构建图，图中结点代表一个单词，每个结点之间如果编辑距离为1，则有一条边

        Queue<Pair> q = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        q.offer( new Pair(beginWord, 1) );
        visited.add( beginWord );

        while( !q.isEmpty() ) {
            // 取出队首元素
            Pair p = q.poll();
            String word = p.word;
            int step = p.step;

            if( word.equals(endWord) )
                return step;

            // 遍历所有元素
            for( String w : wordList ) {
                // 计算距离
                if( helper(word, w) == 1 && !visited.contains( w ) ) {
                    q.offer( new Pair(w, step+1) );
                    visited.add(w);
                }
            }
        }

        return 0;
    }

    private int helper( String w1, String w2 ) {
        assert( w1.length() == w2.length() );

        int dist = 0;
        for( int i = 0; i < w1.length(); i++ ) {
            if( w1.charAt(i) != w2.charAt(i) )
                dist++;
        }

        return dist;
    }

    public static void main(String[] args) {
        // 测试用例
        String beginWord = "red";
        String endWord = "tax";
        List<String> wordList = new LinkedList<>();
        wordList.add("ted");
        wordList.add("tex");
        wordList.add("red");
        wordList.add("tax");
        wordList.add("tad");
        wordList.add("den");
        wordList.add("rex");
        wordList.add("pee");
        WordLadder solution = new WordLadder();
        int res = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }
}
