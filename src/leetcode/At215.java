package leetcode;

import leetcode.test.HeapSort;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class At215 {

    // 用堆求第K大的数，牛逼啊
    public int findKthLargest(int[] nums, int k) {
//        sort(nums, 0, nums.length - 1);
        int n = nums.length;
        buildHeap(nums, n);
        for (int i = n - 1; i >= nums.length - k; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums[nums.length - k];
    }

    // 快排
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

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void buildHeap(int[] nums, int n) {
        int last = n;
        int mid = (last - 1) / 2;
        for (int i = mid; i >= 0; i--) adjustHeap(nums, i, n);
    }

    public void adjustHeap(int[] nums, int i, int n) {
        if (i >= n) return;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && nums[c1] > nums[max]) max = c1;
        if (c2 < n && nums[c2] > nums[max]) max = c2;
        if (max != i) {
            swap(nums, i, max);
            adjustHeap(nums, max, n);
        }
    }

}
