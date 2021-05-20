package leetcode.test;

/**
 * 归并排序
 *
 * 包含自顶向下和自底向上
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int n = arr.length;
        int[] mergeUsedTempArr = new int[n];
//        new MergeSort().mergeSort(arr, mergeUsedTempArr, 0, n - 1);

        new MergeSort().mergeSort2(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    /**
     * 自顶向下
     *
     * @param arr
     * @param mergeUsedTempArr
     * @param start
     * @param end
     */
    public void mergeSort(int[] arr, int[] mergeUsedTempArr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, mergeUsedTempArr, start, mid); // 递归归并左边元素
            mergeSort(arr, mergeUsedTempArr, mid + 1, end); // 递归归并右边元素
            merge(arr, mergeUsedTempArr, start, mid, end); // 再将二个有序数列合并
        }
        // 例外情况就是start = end
        // 也就是只有一个元素，所以不需要排序
    }

    public void merge(int[] arr, int[] mergeUsedArr, int start, int mid, int end) {
        int i = start, j = mid + 1; // i为第一组的起点, j为第二组的起点
        int m = mid, n = end; // m为第一组的终点, n为第二组的终点
        int k = 0; // k用于指向temp数组当前放到哪个位置
        while (i <= m && j <= n) {
            if (arr[i] <= arr[j]) {
                mergeUsedArr[k++] = arr[i++];
            } else {
                mergeUsedArr[k++] = arr[j++];
            }
        }
        while (i <= m) {
            mergeUsedArr[k++] = arr[i++];
        }

        while (j <= n) {
            mergeUsedArr[k++] = arr[j++];
        }

        for (i = 0; i < k; i++) {
            arr[start + i] = mergeUsedArr[i];
        }

    }

    /**
     * 自底向上
     */
    public void mergeSort2(int[] arr) {
        int n = arr.length;
        int[] mergeUsedArr = new int[n];//一次性分配空间

        for (int len = 1; len < n; len = 2 * len) {
            //复制到辅助数组中
            System.arraycopy(arr, 0, mergeUsedArr, 0, n);
            //按照len的长度归并回A数组，归并后长度翻倍
            for (int start = 0; start < n; start = start + 2 * len) {
                int mid = start + len - 1;
                //对于数组长度不满足2的x次幂的数组，mid可能会大于end
                int end = Math.min(start + 2 * len - 1, n - 1);
                int i = start;
                //mid大于end时,j必然大于end,所以不会引起越界访问
                int j = mid + 1;
                //[start,mid] [mid+1, end]
                for (int k = start; k <= end; k++) {
                    if (i > mid) {
                        arr[k] = mergeUsedArr[j++];
                    } else if (j > end) {
                        arr[k] = mergeUsedArr[i++];
                    } else if (mergeUsedArr[i]< mergeUsedArr[j]) {
                        arr[k] = mergeUsedArr[i++];
                    } else {
                        arr[k] = mergeUsedArr[j++];
                    }
                }
            }
        }
    }
}
