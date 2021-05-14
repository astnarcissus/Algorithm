package leetcode;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 */
public class At75 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
        new At75().sortColors(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    /**
     * 经典的荷兰国旗问题
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int index = 0;
        while (index <= r) {
            if (nums[index] == 0) {
                int tmp = nums[index];
                nums[index] = nums[l];
                nums[l] = tmp;
                l++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                int tmp = nums[index];
                nums[index] = nums[r];
                nums[r] = tmp;
                r--;
            }
        }
    }

}
