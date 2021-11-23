package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class At438 {

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("abab","ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 滑动窗口 + 数组
        int n = s.length(),m = p.length();
        if (n < m)
            return res;
        Integer[] sCnt = new Integer[26];
        Integer[] pCnt = new Integer[26];

        for (int i = 0; i < m; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCnt, pCnt))
            res.add(0);

        for(int i = m; i < n; i++) {
            sCnt[s.charAt(i + 1 - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCnt, pCnt))
                res.add(i);
        }
        return res;
    }

    // 双指针
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int n = s.length(), m = p.length();
            List<Integer> res = new ArrayList<>();
            if(n < m) return res;

            int[] pCnt = new int[26];
            int[] sCnt = new int[26];

            for(int i = 0; i < m; i++){
                pCnt[p.charAt(i) - 'a'] ++;
            }

            int left = 0;
            for(int right = 0; right < n; right++){
                int curRight = s.charAt(right) - 'a';
                sCnt[curRight]++;
                while(sCnt[curRight] > pCnt[curRight]){
                    int curLeft = s.charAt(left) - 'a';
                    sCnt[curLeft]--;
                    left++;
                }
                if(right - left + 1 == m){
                    res.add(left);
                }
            }
            return res;
        }
    }

}
