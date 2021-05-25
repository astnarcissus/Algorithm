package leetcode;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 */
public class At169 {

    /**
     * Boyer-Moore 投票算法
     * 一言以蔽之，只要多于半数投自己肯定赢，如果当选人不是自己，则和其他人一起把对方投下场
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int choosed = nums[0];
        int count = 1;
        for (int i = 1; i < n;i++) {
            if (nums[i] == choosed) ++count;
            else --count;
            if (count == 0 && i < n - 1) choosed = nums[i+1];
        }
        return choosed;
    }

}
