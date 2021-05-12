package leetcode;

import java.util.*;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class At39 {

    public static void main(String[] args) {
        System.out.println(new At39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    /**
     * 找子集，dfs是吧，递归回溯喽，再剪个枝
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates.length == 0) return lists;
        Arrays.sort(candidates);
        int n = 0;
        while (n < candidates.length && candidates[n] <= target) n++;
        dfs(0, candidates, 0, new ArrayList<>(), lists, target, n);
        return lists;
    }

    public void dfs(int cur, int[] candidates, int nowSum, List<Integer> nowList, List<List<Integer>> lists, int target, int n) {
        if (cur == n) return;
        if (nowSum == target) {
            lists.add(new ArrayList<>(nowList));
        } else if (nowSum < target) {
            nowSum += candidates[cur];
            nowList.add(candidates[cur]);
            dfs(cur, candidates, nowSum, nowList, lists, target, n);
            nowSum -= candidates[cur];
            nowList.remove(nowList.size() - 1);
            dfs(cur + 1, candidates, nowSum, nowList, lists, target, n);
        }
    }

    /**
     * 别人的解法，我应该也剪枝了呀，很奇怪呢，难道是因为我的树太深了？
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs2(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs2(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);

            dfs2(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }

}
