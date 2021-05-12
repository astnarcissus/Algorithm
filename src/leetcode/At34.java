package leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class At34 {

    public static void main(String[] args) {
        new At34().searchRange2(new int[]{1, 1, 2, 2, 3, 3, 4}, 2);
    }

    /**
     * 两次二分，求求左边界和又边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int l = 0;
        int r = n - 1;
        int mid = -1;
        while (l < r) {
            mid = (l + r) >> 1;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] == target) r = mid;
            else l = mid + 1;
        }
        System.out.println(mid);
        return new int[]{-1, -1};
    }

    /**
     * 二分前后推？不过这样不算O(n)么，先试试
     * <p>
     * 一遍过，我真牛逼
     * <p>
     * 果然人家是两遍二分做的，没有O(n)，我是傻逼
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int l = 0;
        int r = n - 1;
        while (l <= r) {

            int mid = (l + r + 1) >> 1;
            if (nums[mid] == target) {
                int x = mid;
                int y = mid;
                while (x > 0 && nums[x - 1] == nums[x]) x--;
                while (y < n - 1 && nums[y + 1] == nums[y]) y++;
                return new int[]{x, y};
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

}
