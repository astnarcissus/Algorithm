package leetcode;

/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 *
 */
public class At53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1, 2, 3, -3, -5, 6, -11, 33, 2, -22}));
    }

    /**
     * 动态规划，因为只需要上一个下标的状态，所以不用刻意用dp数组维护
     * 还有个分治的写法，暂时不管
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

}
