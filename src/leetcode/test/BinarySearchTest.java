package leetcode.test;

/**
 * @author: 言叶长琴
 *
 * 关于二分查找边界的一些测试，运用遵循 循环不变量[left..right)的思想
 * 二分的细节还是很能扣出一些东西的，不过最重要的是，思路要清晰的一条流走下来
 * 因为不同的人对于区间以及闭合的取法不一样，所以代码的实现也不一样
 *
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 5, 6, 7};
        int[] nums2 = new int[]{1, 1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 8, 8, 8};

        BinarySearchTest test = new BinarySearchTest();
        System.out.println(test.binarySearch(nums, 4));
        System.out.println(test.binarySearch(nums2, 8));

        System.out.println(test.binarySearch2(nums, 3));
        System.out.println(test.binarySearch2(nums2, 3));
    }

    /**
     * 查找左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
//            System.out.println("low = " + low);
//            System.out.println("high = " + high);
//            System.out.println("mid = " + mid);
            if (nums[mid] == target) high = mid;
            else if (nums[mid] > target) high = mid;
            else low = mid + 1;
        }
        if (low == nums.length || nums[low] != target) return -1;
        return low;
    }

    /**
     * 查找右边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch2(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
//            System.out.println("low = " + low);
//            System.out.println("high = " + high);
//            System.out.println("mid = " + mid);
            if (nums[mid] == target) low = mid + 1;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
//        System.out.println("low = " + low);
//        System.out.println("nums[low - 1] = " + nums[low - 1]);
        if (low == 0 || nums[low - 1] != target) return -1;
        return low;
    }
}
