package leetcode;

import java.util.*;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * (手机九宫格)
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class At17 {

    public static void main(String[] args) {
        System.out.println(new At17().letterCombinations("23456"));
    }

    /**
     * 回溯，一把过，真爽啊
     * 不过没想到的就是泛型居然可以用数组，虽然我知道其实都是引用，不过又涨知识了呢。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        char[] charArr = digits.toCharArray();
        int n = charArr.length;
        // 判断写在前面，针对此类特殊情况，就不用生成map的空间了
        if (n == 0) return list;

        Map<Character, char[]> listHashMap = new HashMap<>();
        listHashMap.put('2', new char[]{'a', 'b', 'c'});
        listHashMap.put('3', new char[]{'d', 'e', 'f'});
        listHashMap.put('4', new char[]{'g', 'h', 'i'});
        listHashMap.put('5', new char[]{'j', 'k', 'l'});
        listHashMap.put('6', new char[]{'m', 'n', 'o'});
        listHashMap.put('7', new char[]{'p', 'q', 'r', 's'});
        listHashMap.put('8', new char[]{'t', 'u', 'v'});
        listHashMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        dfs(0, n, charArr, new StringBuilder(), list, listHashMap);
        return list;
    }

    public void dfs(int cur, int n, char[] charArr, StringBuilder nowStr, List<String> list, Map<Character, char[]> listHashMap) {
        if (cur == n) {
            list.add(new String(nowStr));
            return;
        }

        char[] charToNum = listHashMap.get(charArr[cur]);

        for (int i = 0; i < charToNum.length; i++) {
            nowStr.append(charToNum[i]);
            dfs(cur + 1, n, charArr, nowStr, list, listHashMap);
            nowStr.deleteCharAt(nowStr.length() - 1);
        }
    }

}
