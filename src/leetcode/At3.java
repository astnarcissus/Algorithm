package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: 言叶长琴
 */
public class At3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("aabcdcde"));
//        System.out.println(lengthOfLongestSubstring1("abab"));
    }

    // 通过hashmap来求同一字符上一次出现位置的下一个位置
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        // 记录字符上一次出现的下标
        Map<Character, Integer> map = new HashMap<>();
        // 窗口的左位置
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 防止abab的情况，中间字符的下标可能小于已经移位完成的左位置
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            // i即作为窗口的右位置
            res = Math.max(res, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }

    // 暴力
    public static int lengthOfLongestSubstring1(String s) {

        if (s.length() == 0) return 0;
        int start = 0;
        int end = 0;
        int res = 0;
        int length = 0;
        while (end < s.length()) {
            char tmpChar = s.charAt(end);
            for (int index = start; index < end; index++) {
                if (tmpChar == s.charAt(index)) {
                    start = index + 1;
                    length = end - start;
                    break;
                }
            }
            end++;
            length++;
            res = Math.max(res, length);
        }

        return res;
    }

    // set
    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
