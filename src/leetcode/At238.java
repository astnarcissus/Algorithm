package leetcode;

/**
 * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 */
public class At238 {

    /**
     * 左侧乘积 * 右侧乘积
     * 不能用除法
     * 太牛了
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = nums[i] * res[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i > 0; i--) {
            res[i] = r * res[i - 1];
            r *= nums[i];
        }
        res[0] = r;

        return res;
    }

}
