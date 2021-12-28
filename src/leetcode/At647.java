package leetcode;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class At647 {

    // 本来想写dfs/bfs的，不过感觉只要确定子串的样子，就可以直接得到值了，所以现在的问题就是怎么判断子串是回文串？

    // 判断中心回文
    public int countSubstrings(String s) {

        // 针对长度为奇数/偶数做判断
        int n = s.length(), res = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                ++res;
                --l;
                ++r;
            }
        }

        return res;

    }

}
