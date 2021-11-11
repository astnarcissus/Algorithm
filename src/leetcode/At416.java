package leetcode;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class At416 {

    public static void main(String[] args) {
        System.out.println(new At416().canPartition(new int[]{1, 5, 10, 6}));
    }

    /**
     * 遍历子集，和为sum一半
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        int v = sum / 2;

        boolean[] dp = new boolean[v + 1];
        dp[0] = true;
        if (nums[0] <= v) dp[nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = v; j >= nums[i]; j--) {
                if (dp[v]) return true;
                if (j > nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return false;
    }

}
