package leetcode;

/**
 * @author: 言叶长琴
 * <p>
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class At55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0, 2, 3}));
    }

    /**
     * 一开始莫名其妙想的是dp？也是很奇怪了
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {

//        int n = nums.length;
//        boolean[] dp = new boolean[n];
//        dp[0] = true;
//        for (int i = 0; i < n - 1; i++) {
//            if (nums[i] > 0)
//                for (int j = 1; j <= nums[i] && i + j < n; j++) {
//                    if (i + j == n - 1 && dp[i]) return true;
//                    dp[i + j] = dp[i];
//                }
//        }
//        return dp[n - 1];
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;

    }

}
