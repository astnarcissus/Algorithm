package leetcode;

public class At338 {

    /**
     * 位运算 + 动态规划
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    /**
     * Brian Kernighan 算法
     * 最直观的做法是对从 0 到 n 的每个整数直接计算「一比特数」。每个 int 型的数都可以用 32 位二进制数表示，只要遍历其二进制表示的每一位即可得到 1 的数目。
     *
     * 利用 Brian Kernighan 算法，可以在一定程度上进一步提升计算速度。
     * Brian Kernighan 算法的原理是：对于任意整数 x，令 x=x&(x-1)，该运算将 x 的二进制表示的最后一个 1 变成 0。因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     */
    public int[] countBits2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }

    /**
     *
     * @param n
     * @return
     */
    public int[] countBits3(int n) {
        int[] dp = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) highBit = i;
            dp[i] = dp[i - highBit] + 1;
        }
        return dp;
    }

}
