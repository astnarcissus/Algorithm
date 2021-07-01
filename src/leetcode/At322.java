package leetcode;

import sun.awt.IconInfo;

import java.util.Arrays;

public class At322 {

    public static void main(String[] args) {
        System.out.println(new At322().coinChange(new int[]{2147483647},2));
    }

    /**
     * 简单的DP吧
     *
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int k = 0; k < coins.length; k++) {
                if (i - coins[k] >= 0)
                    dp[i] = Math.min(dp[i],dp[i - coins[k]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
