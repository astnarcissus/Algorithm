package leetcode.test;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        HeapSort heapSort = new HeapSort();
        heapSort.print(nums);
        int n = nums.length;
        heapSort.buildHeap(nums, n);
        for (int i = n - 1; i >= 0; i--) {
            heapSort.swap(nums, 0, i);
            heapSort.adjustHeap(nums, 0, i);
        }
        heapSort.print(nums);
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
