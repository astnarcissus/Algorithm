package leetcode;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 */
public class At31 {

    public static void main(String[] args) {
        new At31().nextPermutation(new int[]{1,1,3});
    }

    /**
     * 暴力，不过时间复杂度是O(n²)啊，诶
     * 不过这个写法错了233
     * 132
     * 213才是正解
     * 而这种方法解出来的是231
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        boolean flg = false;
        for(int i = nums.length - 1; i >0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && !flg) {
                    flg = true;
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }

        if (!flg) Arrays.sort(nums);
    }

}
