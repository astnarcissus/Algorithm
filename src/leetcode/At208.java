package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *  
 *
 * 示例：
 *
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 */
public class At208 {

}

/**
 * 牛逼啊，一遍过，不愧是我，不过这个说到底也就是个字典树
 * 当然这边有可以优化的地方，就是map用数组表示，之前忘记了对象类型的数组，emmmm，不应该
 */
class Trie {

    class Node {
        boolean endFlg;
        Map<Character, Node> nextMap;

        Node() {
            this.endFlg = false;
            this.nextMap = new HashMap<>();
        }

    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!cur.nextMap.containsKey(chars[i])) cur.nextMap.put(chars[i],new Node());
            cur = cur.nextMap.get(chars[i]);
        }
        cur.endFlg = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!cur.nextMap.containsKey(chars[i])) return false;
            cur = cur.nextMap.get(chars[i]);
        }
        return cur.endFlg;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!cur.nextMap.containsKey(chars[i])) return false;
            cur = cur.nextMap.get(chars[i]);
        }
        return true;
    }
}

/**
 * 果然用数组快了不少，不过这也是基于题目限定了字母是小写字母的原因
 *
 * 而且CP方法的时候，没注意，报错了两次，可恶
 *
 */
class ArrayTrie {

    class Node {
        boolean endFlg;
        Node[] next;

        Node() {
            this.endFlg = false;
            this.next = new Node[26];
        }

    }

    Node root;

    /** Initialize your data structure here. */
    public ArrayTrie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i]-'a';
            if (cur.next[idx] == null) cur.next[idx] = new Node();
            cur = cur.next[idx];
        }
        cur.endFlg = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i]-'a';
            if (cur.next[idx] == null) return false;
            cur = cur.next[idx];
        }
        return cur.endFlg;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i]-'a';
            if (cur.next[idx] == null) return false;
            cur = cur.next[idx];
        }
        return true;
    }
}