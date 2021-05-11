package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 * 输入：nums = [1,1,2]
 * 输出：1
 * <p>
 * 进阶：
 * <p>
 * 如何证明 nums 中至少存在一个重复的数字?
 * 你可以在不修改数组 nums 的情况下解决这个问题吗？
 * 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
 * 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
 */
public class At287 {

    public static void main(String[] args) {
//        System.out.println(new At287().findDuplicate(new int[]{1,5,2,3,4,5}));

        System.out.println(new At287().findDuplicate3(new int[]{1, 6, 2, 6, 6, 6, 5, 7}));

    }

    /**
     * 好的，最粗制滥造的解法，时间复杂度、空间复杂度都不符合要求。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int val = 0;
        Set<Integer> existsSet = new HashSet<>();
        for (int num : nums) {
            if (existsSet.contains(num)) {
                val = num;
                break;
            }
            existsSet.add(num);
        }

        return val;
    }

    /**
     * 简单的进阶
     *
     * 之前没有注意到长度为n+1的数组内的数，其大小为1~n之间
     *
     * 类似双指针，参考At142求环
     *
     * 讲真，有点意思
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 二分查找
     * 重点还是在[长度为n+1的数组内的数，其大小为1~n之间]
     * 不过这题加上各种限制条件，基本上就只能时间换空间了，有点反人类的思路，妈的
     *
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int left = 1;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }

            if (cnt > mid) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
