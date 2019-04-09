/**
 * Created by Nelson on 2019/4/9.
 */

/**
 * 1024. Video Stitching
 * https://leetcode.com/problems/video-stitching/
 */

import java.util.*;

public class VideoStitching {

    public int videoStitching(int[][] clips, int T) {
        // 思路：贪心算法
        // 按照clips的左边界从小到大排序
        // 首先判断最小的左边界是不是0，不是的话直接返回-1；
        // 否则去找右边界最大的区间，确定当前的currEnd
        // 判断currEnd >= T ？
        // 接着去找下面的clips，找所有左边界<=currEnd的右边界最大的那个clip，接着循环，直到满足条件

        int len = clips.length;
        if( len == 0 )
            return -1;

        // 对clips排序
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if( o1[0] != o2[0] )
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        // 贪心算法

        int maxEnd = 0;  // 记录当前所有满足条件的clips中的最大右边界
        int currEnd = 0;  // 记录当前已经cover的视频区间右边界
        int ret = 0;  // 返回值

        int i = 0;
        // 遍历排序后的clips
        while( i < len ) {
            // 如果当前clips的左边界已经超过了当前cover区间的右边界，说明出现断层，直接返回-1
            if( clips[i][0] > currEnd )
                return -1;

            // 寻找当前左区间小于currEnd的最大右边界clips
            while( i < len && clips[i][0] <= currEnd ) {
                maxEnd = Math.max(maxEnd, clips[i][1]);
                i++;
            }

            // 更新右边界
            currEnd = maxEnd;
            ret++;

            // 判断当前是否可以跳出
            if( currEnd >= T )
                return ret;
        }

        // 兜底
        return -1;
    }

    public static void main(String[] args) {
        // 测试用例
        int[][] clips = new int[][]{
                {0,2},
                {4,6},
                {8,10},
                {1,9},
                {1,5},
                {5,9}
        };

        int T = 10;

        VideoStitching solution = new VideoStitching();
        System.out.println(solution.videoStitching(clips, T));
    }
}
