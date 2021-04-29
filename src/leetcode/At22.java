package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 */
public class At22 {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(generateParenthesis(3)));
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        adStr(0,0,n,"",list);
        return list;
    }

    /**
     * 没看题解，找规律递归？
     * 感觉理解了就不难
     * @param l
     * @param r
     * @param n
     * @param nowStr
     * @param list
     */
    public static void adStr(int l, int r, int n, String nowStr, List<String> list) {
        if (l == n) {
            if (r == n) {
                list.add(nowStr);
            } else if (r < n) {
                adStr(l, r + 1, n, nowStr + ")", list);
            }
        } else {
            adStr(l + 1, r, n, nowStr + "(", list);
            if (l > r) adStr(l, r + 1, n, nowStr + ")", list);
        }

    }
}
