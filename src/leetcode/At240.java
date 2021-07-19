package leetcode;

/**
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 */
public class At240 {

    /**
     * 题解的解法四，确实厉害，除此之外还有暴力，二分，缩减搜索空间
     *
     *首先，我们初始化一个指向矩阵左下角的 (row，col)(row，col) 指针。
     * 然后，直到找到目标并返回 true（或者指针指向矩阵维度之外的 (row，col)(row，col) 为止，
     * 我们执行以下操作：如果当前指向的值大于目标值，则可以 “向上” 移动一行。
     * 否则，如果当前指向的值小于目标值，则可以移动一列。不难理解为什么这样做永远不会删减正确的答案；
     * 因为行是从左到右排序的，所以我们知道当前值右侧的每个值都较大。
     * 因此，如果当前值已经大于目标值，我们知道它右边的每个值会比较大。
     * 也可以对列进行非常类似的论证，因此这种搜索方式将始终在矩阵中找到目标（如果存在）。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int x = m - 1;
        int y = 0;
        while(x >= 0 && y < n) {
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] < target) ++y;
            else --x;
        }
        return false;
    }

}
