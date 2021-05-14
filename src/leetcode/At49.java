package leetcode;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class At49 {

    public static void main(String[] args) {
        System.out.println(new At49().groupAnagrams(new String[]{"aacc", "bd"}));
    }


    /**
     * 常规的就是sort之后放到set中，每次进行比较
     * 后来简单想了下，sort的过程也至少是O(nlogn)的时间复杂度，所以还是直接看以下的解法吧
     * <p>
     * 无意间瞥见了一种解法，是将字符出现的次数和字符拼成一个新的字符串放到set中，
     * 对于很长的字符串，应该可以很有效的优化比较的时间。
     * <p>
     * 可能有stream的方便操作，不过大致的思路还是记数
     *
     * 讨论区分享 在美版leetcode上看到大神的思路，用质数表示26个字母，把字符串的各个字母相乘，这样可保证字母异位词的乘积必定是相等的。其余步骤就是用map存储，和别人的一致了。（这个用质数表示真的很骚啊！！!）
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    stringBuilder.append((char) ('a' + i));
                    stringBuilder.append(counts[i]);
                }
            }
            String key = stringBuilder.toString();
            System.out.println(key);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }

}
