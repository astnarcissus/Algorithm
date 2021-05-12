package leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 */
public class At33 {

    public static void main(String[] args) {
        System.out.println(new At33().search2(
                new int[]{3, 5, 1}, 3));
    }

    /**
     * 直接遍历简直连傻瓜题都不如
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
     * 注意题中所说，初始nums为升序序列，并且旋转过后也是升序序列（两段）
     * 所以往二分思考
     *
     * 我们可以在常规二分查找的时候查看当前 mid 为分割位置分割出来的两个部分 [l, mid] 和 [mid + 1, r] 哪个部分是有序的，并根据有序的那个部分确定我们该如何改变二分查找的上下界，因为我们能够根据有序的那部分判断出 target 在不在这个部分：
     *
     * 如果 [l, mid - 1] 是有序数组，且 target 的大小满足 [nums[l],nums[mid]，则我们应该将搜索范围缩小至 [l, mid - 1]，否则在 [mid + 1, r] 中寻找。
     * 如果 [mid, r] 是有序数组，且 target 的大小满足 [nums[mid+1],nums[r]]，则我们应该将搜索范围缩小至 [mid + 1, r]，否则在 [l, mid - 1] 中寻找。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid])
            {
                if (target >= nums[l] && target < nums[mid])
                    r = mid-1;
                else
                    l = mid+1;
            }
            else
            {
                if (target > nums[mid] && target <= nums[r])
                    l = mid +1;
                else
                    r = mid -1;
            }

            // 我稀烂的判断，啊，不想写了
//            if (nums[l] < nums[r]) {
//                // 正常二分
//                if (nums[mid] < target) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            } else {
//                // 额外判断二分
//                if (nums[mid] < target) {
//                    if (nums[mid] >= nums[l] && nums[l] > target) {
//                        l = mid + 1;
//                    } else {
//                        r = mid - 1;
//                    }
//                } else {
//                    if (nums[mid] >= nums[l] && nums[l] < target) {
//                        r = mid - 1;
//                    } else {
//                        l = mid + 1;
//                    }
//                }
//            }
        }
        return -1;
    }

}
