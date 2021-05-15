package leetcode;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 * @author: 言叶长琴
 */
public class At79 {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(new At79().exist(board, word));
    }


    boolean ans = false;

    /**
     * 在学校里的时候就做过这种题了，诶，严格来说算最早接触过的中等难度呢。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chars[0]) {
                    if (chars.length == 1) return true;
                    used[i][j] = true;
                    dfs(i, j, board, 0, chars, used);
                    used[i][j] = false;
                    if (ans) return true;
                }
            }
        }

        return false;
    }

    public void dfs(int x, int y, char[][] board, int curChar, char[] chars, boolean[][] used) {
        if (y - 1 >= 0 && curChar + 1 < chars.length && board[x][y - 1] == chars[curChar + 1] && !used[x][y - 1]) {
            if (curChar + 1 == chars.length - 1 && board[x][y - 1] == chars[curChar + 1]) {
                ans = true;
                return;
            } else {
                used[x][y - 1] = true;
                dfs(x, y - 1, board, curChar + 1, chars, used);
                used[x][y - 1] = false;
            }
        }
        if (y + 1 < board[0].length && curChar + 1 < chars.length && board[x][y + 1] == chars[curChar + 1] && !used[x][y + 1]) {
            if (curChar + 1 == chars.length - 1 && board[x][y + 1] == chars[curChar + 1]) {
                ans = true;
                return;
            } else {
                used[x][y + 1] = true;
                dfs(x, y + 1, board, curChar + 1, chars, used);
                used[x][y + 1] = false;
            }
        }
        if (x - 1 >= 0 && curChar + 1 < chars.length && board[x - 1][y] == chars[curChar + 1] && !used[x - 1][y]) {
            if (curChar + 1 == chars.length - 1 && board[x - 1][y] == chars[curChar + 1]) {
                ans = true;
                return;
            } else {
                used[x - 1][y] = true;
                dfs(x - 1, y, board, curChar + 1, chars, used);
                used[x - 1][y] = false;
            }
        }
        if (x + 1 < board.length && curChar + 1 < chars.length && board[x + 1][y] == chars[curChar + 1] && !used[x + 1][y]) {
            if (curChar + 1 == chars.length - 1 && board[x + 1][y] == chars[curChar + 1]) {
                ans = true;
                return;
            } else {
                used[x + 1][y] = true;
                dfs(x + 1, y, board, curChar + 1, chars, used);
                used[x + 1][y] = false;
            }
        }
    }

}
