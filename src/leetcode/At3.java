package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 言叶长琴
 */
public class At3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabcdcde"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            res = Math.max(res, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }


}
