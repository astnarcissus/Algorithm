package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 言叶长琴
 * <p>
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class At78 {

    public static void main(String[] args) {
        System.out.println(new At78().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfs(0, nums, ans, list);
        return ans;
    }

    /**
     * 简而言之本题就是递归回溯，查找子集
     * 该解法主要是相当于每次对于当前状态的下一步进行抉择，是否将下一个加入已存在的状态，若加入，则在加入完成执行后需还原状态。
     * @param cur
     * @param nums
     * @param ans
     * @param list
     */
    public void dfs(int cur, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(cur + 1, nums, ans, list);
        list.add(nums[cur]);
        dfs(cur + 1, nums, ans, list);
        list.remove(list.size() - 1);
    }

}
