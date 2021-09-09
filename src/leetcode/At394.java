package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class At394 {

    public static void main(String[] args) {
        System.out.println(new At394().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        return dfs(1, s);
    }

    /**
     * 递归
     * 1. 没想到数字可能是多位数的情况 （100），代码写的不优美
     *
     * @param times
     * @param s
     * @return
     */
    public String dfs(int times, String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                StringBuilder tStr = new StringBuilder();
                while (chars[i] != '[') {
                    tStr.append(chars[i]);
                    ++i;
                }
                int t = Integer.parseInt(tStr.toString());
                --i;
                int start = i;
                int len = 0;
                int l = 1;
                int r = 0;
                while (l != r) {
                    ++len;
                    if (chars[start + 2 + len] == '[') l++;
                    if (chars[start + 2 + len] == ']') r++;
                }
                sb.append(dfs(t, s.substring(start + 2, start + 2 + len)));
                i += (len + 2);
            } else {
                sb.append(chars[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < times; i++) {
            res.append(sb);
        }
        return res.toString();
    }

    /**
     * 栈
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }

    /**
     * 递归
     * @param s
     * @return
     */
    public String decodeString3(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[]{res.toString()};
    }

}
