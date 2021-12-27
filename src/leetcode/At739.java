package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class At739 {

    public static void main(String[] args) {
        new At739().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] res = new int[n];
        int maxi = n - 1;

        int i = n - 2;

        while (i >= 0) {
            if (temperatures[i] >= temperatures[maxi]) {
                res[i] = 0;
                maxi = i;
            } else {

                for (int j = i + 1; j <= maxi; j++) {
                    if (temperatures[j] > temperatures[i]) {
                        res[i] = j - i;
                        break;
                    }
                }
            }
            --i;
        }

        return res;
    }

    /**
     * 单调栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];

            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }


}
