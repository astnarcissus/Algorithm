package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class At56 {

    public static void main(String[] args) {
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {10, 13}};
        new At56().merge(intervals);
    }


    /**
     * 排序+合并
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int[] interval : intervals) {
            // 因为已经是排序好的，所以不需要遍历list筛选
            int L = interval[0], R = interval[1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < L) {
                list.add(new int[]{L, R});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
