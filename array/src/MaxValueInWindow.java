/**
 * Created by Nelson on 2019/8/8.
 */

/**
 * 剑指offer中的题目
 * 给定一个数组nums，以及一个窗口size，返回一个列表，存储从[0...nums.length-1]每个size窗口下的最大值
 */
import java.util.*;

class Pair {
    int value;
    int index;
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class MaxValueInWindow {

    public ArrayList<Integer> maxValueInWindow(int[] nums, int k) {
        // 思路：考虑滑动[l...l+k-1]区间内的最大值，需要O(k)时间复杂度
        // 令l从0开始滑动到结束，统计最大值返回，总体上大概需要遍历n个数
        // 暴力解法时间复杂度为O(nk)
        // 考虑到在滑动窗口过程中，窗口左侧元素会移出，右侧会新纳入一个元素，其实当旧元素和新元素比窗口内最大值小的情况下，是不需要重新遍历求解的
        // 因此，这个题其实能够最直观的想到维持一个k个元素的最大堆，堆中存储元素值以及对应的索引号，当有新元素进来的时候，意味着最左侧的元素要移出窗口：
        // 1.先判断堆顶元素（窗口内最大元素）的索引号是不是左边界，如果是的话，意味着最大值要更新，此时移出堆顶元素，放入新元素
        // 2.如果窗口内最大元素不是左边界，那么新进来的元素直接入堆就可以
        // 3.用O(1)时间复杂度取出堆顶元素

        ArrayList<Integer> res = new ArrayList<>();

        int len = nums.length;
        if( len == 0 || len < k || k <= 0 )
            return res;

        // 构建一个最大堆
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if( o1.value != o2.value ) {
                    return o2.value - o1.value;
                }
                return o2.index - o1.index;
            }
        });

        // 放入从[0...k-1]的元素
        for( int i = 0; i < k; i++ ) {
            pq.offer(new Pair(nums[i], i));
        }

        // 此时加入堆顶元素，为第一个窗口内的最大值
        res.add(pq.peek().value);

        // 开始移动窗口
        // 窗口的左边界
        int l = 0;
        for( int i = k; i < len; i++ ) {
            // 先判断堆顶元素的索引是否为左边界
            Pair p = pq.peek();
            // 如果堆顶元素是左边界元素，那么移除左边元素
            if( p.index == l ) {
                pq.poll();
                pq.offer(new Pair(nums[i], i));
                l++;
            } else { // 否则，直接往堆中加入元素，因为不影响最大值
                pq.offer(new Pair(nums[i], i));
                l++;
            }

            // 加入堆顶元素
            res.add(pq.peek().value);
        }

        return res;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = new int[]{1, 2, 3, 4, 2, 5, 6, 8, 1, 2, 9};
        int k = 3;
        MaxValueInWindow solution = new MaxValueInWindow();
        ArrayList<Integer> res = solution.maxValueInWindow(nums, k);
        for( int n : res ) {
            System.out.println(n);
        }
    }
}
