package leetcode;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class At200 {

    public static void main(String[] args) {
        System.out.println(new At200().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }

    int res = 0;
    boolean[][] visited;
    int m, n;

    /**
     * 海岛问题，大学就做过了
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ++res;
                    dfs(grid, i, j);
                }
            }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        if (x + 1 < m && grid[x + 1][y] == '1' && !visited[x + 1][y]) dfs(grid, x + 1, y);
        if (y + 1 < n && grid[x][y + 1] == '1' && !visited[x][y + 1]) dfs(grid, x, y + 1);
        if (x - 1 >= 0 && grid[x - 1][y] == '1' && !visited[x - 1][y]) dfs(grid, x - 1, y);
        if (y - 1 >= 0 && grid[x][y - 1] == '1' && !visited[x][y - 1]) dfs(grid, x, y - 1);
    }

}
