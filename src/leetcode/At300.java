package leetcode;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 */
public class At300 {

    /**
     * 动态规划，和我想的差不多其实
     * 时间复杂度 O(n²)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 动态规划+二分查找
     * 具体实现那块还是对二分有点小烦，诶
     *
     * 很具小巧思。新建数组 cell，用于保存最长上升子序列。
     * <p>
     * 对原序列进行遍历，将每位元素二分插入 cell 中。
     * <p>
     * 如果 cell 中元素都比它小，将它插到最后
     * 否则，用它覆盖掉比它大的元素中最小的那个。
     * 总之，思想就是让 cell 中存储比较小的元素。这样，cell 未必是真实的最长上升子序列，但长度是对的。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] tail = new int[n];
        for (int num : nums) {
            int l = 0;
            int r = res;
            while (l < r) {
                int mid = l + (r - l ) / 2;
                if (tail[mid] < num) l = mid + 1;
                else r = mid;
            }
            tail[l] = num;
            if (l == res)
                ++res;
        }
        return res;
    }
}
