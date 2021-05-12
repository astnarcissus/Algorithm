package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class At46 {

    public static void main(String[] args) {
        System.out.println(new At46().permute(new int[]{1, 2, 3}));
    }

    /**
     * 又是全排列子集什么的呢
     * 又一遍过了，挺爽的呢。
     *
     * 好像和题解差不多，看来大家的思路都出奇的一致
     * used数组这种方法是上学的时候学的了，诶
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return lists;
        boolean[] used = new boolean[n];
        dfs(used, nums, new ArrayList<>(), lists);
        return lists;
    }

    public void dfs(boolean[] used, int[] nums, List<Integer> nowList, List<List<Integer>> lists) {
        if (nowList.size() == nums.length) {
            lists.add(new ArrayList<>(nowList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                nowList.add(nums[i]);
                dfs(used, nums, nowList, lists);
                used[i] = false;
                nowList.remove(nowList.size() - 1);
            }
        }
    }

}
