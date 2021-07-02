package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 *
 */
public class At448 {

    public static void main(String[] args) {
        new At448().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

    /**
     * 原本是想用visit数组的，不过进阶要求常数空间
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            nums[(num - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }

}
