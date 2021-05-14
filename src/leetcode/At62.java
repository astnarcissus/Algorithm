package leetcode;

public class At62 {

    public static void main(String[] args) {
        System.out.println(new At62().uniquePaths(2, 3));
    }

    /**
     * 原本用dfs的，不过超时了，这种情况一般就是动态规划dp了，避免重复递归，合理剪枝
     * 不过还是超时了，妈的
     * 不对，没超时，我忘记贴过去了，妈的
     * 当然还是可以优化的，使用滚动数组
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 解法2
     * 数学，虽然有想法，不过没推，诶，感觉老了就懒了
     *从左上角到右下角的过程中，我们需要移动 m+n-2m+n−2 次，
     * 其中有 m-1m−1 次向下移动，n-1n−1 次向右移动。
     * 因此路径的总数，就等于从 m+n-2m+n−2 次移动中选择 m-1m−1 次向下移动的方案数
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }


}
