package leetcode.test;

import java.util.Arrays;

/**
 * 快排喽
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nums = {9, 8, 7, 8, 6, 8, 9, 8};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        new QuickSort().sort2(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 以升序为例子
     * 注意 边界情况
     * 1. 如果判断条件为left < right, 那么最后得到的left有可能是 小于pivot的
     * 也就是说，这种情况，不需要将两者进行交换的。
     * <p>
     * 并且，如果在左侧有与pivot相同的数，那么有可能会出现这种情况
     * 1、最后得到的left < pivot，那么不需要将pivot 与 left进行交换，但是left左侧可能存在 > left 的数
     * 所以这种情况下，后续快排的右边界不能取left - 1
     * <p>
     * 2. 而对于判断条件为left <= right的情况，如果所有数都小于pivot，那么left = pivot 就是出循环时的情况
     * 所以此时的left即是pivot本身，可以安心地取left - 1作为下次的边界
     *
     * @param nums
     * @param leftBound
     * @param rightBound
     */
    public void sort(int[] nums, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int left = leftBound;
        int right = rightBound - 1;
        int pivot = nums[rightBound];
        while (left <= right) {
            while (left <= right && nums[left] <= pivot) ++left;
            while (left <= right && nums[right] >= pivot) --right;
            if (left < right) swap(nums, left, right);

        }
        swap(nums, left, rightBound);
        sort(nums, leftBound, left - 1);
        sort(nums, left + 1, rightBound);
    }

    public void sort2(int[] nums, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int left = leftBound;
        int right = rightBound - 1;
        int pivot = nums[rightBound];
        while (left < right) {
            while (left < right && nums[left] <= pivot) ++left;
            while (left < right && nums[right] > pivot) --right;
            if (left < right) swap(nums, left, right);

        }
        if (pivot < nums[left])
            swap(nums, left, rightBound);
        sort(nums, leftBound, left);
        sort(nums, left + 1, rightBound);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

    }

}
