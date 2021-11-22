package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 * <p>
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * <p>
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class At399 {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(new ArrayList<String>());
        equations.add(new ArrayList<String>());
        equations.get(0).add("a");
        equations.get(0).add("b");
        equations.get(1).add("b");
        equations.get(1).add("c");

        double[] values = new double[]{2.0d, 3.0d};

        List<List<String>> queries = new ArrayList<>();
        queries.add(new ArrayList<String>());
        queries.add(new ArrayList<String>());
        queries.add(new ArrayList<String>());
        queries.add(new ArrayList<String>());
        queries.add(new ArrayList<String>());
        queries.get(0).add("a");
        queries.get(0).add("c");
        queries.get(1).add("b");
        queries.get(1).add("a");
        queries.get(2).add("a");
        queries.get(2).add("e");
        queries.get(3).add("a");
        queries.get(3).add("a");
        queries.get(4).add("x");
        queries.get(4).add("x");

        new At399().calcEquation(equations, values, queries);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // 1.string 对 id
        HashMap<String, Integer> hashMap = new HashMap<>(2 * equations.size());
        UnionSetFind unionSetFind = new UnionSetFind(2 * equations.size());
        // 1.合并
        int idx = 0;
        for (int i = 0; i < equations.size(); i++) {

            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, idx++);
            }

            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, idx++);
            }

            unionSetFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 2.查询
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Integer idx1 = hashMap.get(queries.get(i).get(0));
            Integer idx2 = hashMap.get(queries.get(i).get(1));

            if (idx1 == null || idx2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionSetFind.isConnect(idx1, idx2);
            }
        }

        return res;
    }

    class UnionSetFind {

        int[] unionSet;
        double[] weight;

        UnionSetFind(int n) {
            unionSet = new int[n];
            weight = new double[n];
            for (int i = 0; i < n; i++) {
                unionSet[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int idx, int idx2, double value) {
            int rootX = find(idx);
            int rootY = find(idx2);
            if (rootX == rootY) return;
            unionSet[rootX] = find(rootY);
            weight[rootX] = weight[idx2] * value / weight[idx];
        }

        public int find(int index) {
            if (unionSet[index] != index) {
                // 这里一开始一直以为是在合并的时候做的操作，实则不然，这边是在查询的时候做的
                // 就如例1，刚开始的时候还是a->b->c;对应的权值就是当前的父节点
                // 合并的时候就要改变副结点了，太绝了。
                int origin = unionSet[index];
                unionSet[index] = find(unionSet[index]);
                weight[index] *= weight[origin];
            }
            return unionSet[index];
        }

        public double isConnect(int idx, int idx2) {
            int rootX = find(idx);
            int rootY = find(idx2);
            if (rootX == rootY) {
                return weight[idx] / weight[idx2];
            }
            return -1.0d;
        }

    }

}
