package leetcode;

/**
 * @author: 言叶长琴
 */
public class At5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaa"));
    }

    /**
     * 简单的动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        // 先枚举子串长度
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = len + i - 1;
                if (j >= n) break;
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
