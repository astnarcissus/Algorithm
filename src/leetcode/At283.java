package leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class At283 {

    /**
     * 我一开始的想法也是把不是0 的往前赋值，然后补 0
     * 然后官方题解是这么讲的
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     *
     * 有点？快排的思想？以0为界，放左放右
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, l = 0, r = 0;
        while (r < n) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                ++l;
            }
            ++r;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
