package leetcode;

/**
 * @author: 言叶长琴
 */
public class At29 {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    /**
     * 最朴素的解法，超时了，诶
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        int res = 0;
        int flg = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            flg = -1;
        }
        if (dividend > 0) dividend *= -1;
        if (divisor > 0) divisor *= -1;
        while (dividend < 0 && dividend <= divisor) {
            res++;
            dividend -= divisor;
        }
        if (res == Integer.MIN_VALUE && flg == 1) return Integer.MAX_VALUE;
        return res * flg;
    }

}
