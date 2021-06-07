package leetcode;

import javax.jnlp.ClipboardService;
import java.util.*;

/**
 *
 */
public class At207 {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        System.out.println(new At207().canFinish(2, prerequisites));
    }

    /**
     * 简而言之，化作图，然后判断有没有环
     * dfs
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] marked = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (dfs(graph, marked, i)) return false;
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int[] marked, int idx) {
        if (marked[idx] == 1) return true;
        if (marked[idx] == 2) return false;

        marked[idx] = 1;

        for (int i = 0; i < graph.get(idx).size(); i++) {
            if (dfs(graph,marked,graph.get(idx).get(i))) return true;
        }

        marked[idx] = 2;
        return false;
    }

    /**
     * 简而言之，化作图，然后判断有没有环
     * bfs(拓扑排序)
     * 1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 00 的结点放入队列。
     *
     * 2、只要队列非空，就从队首取出入度为 00 的结点，将这个结点输出到结果集中，并且将这个结点的所有邻接结点（它指向的结点）的入度减 11，在减 11 以后，如果这个被减 11 的结点的入度为 00 ，就继续入队。
     *
     * 3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。
     *
     * 思考这里为什么要使用队列？（马上就会给出答案。）
     *
     * 在代码具体实现的时候，除了保存入度为 0 的队列，我们还需要两个辅助的数据结构：
     *
     * 1、邻接表：通过结点的索引，我们能够得到这个结点的后继结点；
     *
     * 2、入度数组：通过结点的索引，我们能够得到指向这个结点的结点个数。
     *
     * 这个两个数据结构在遍历题目给出的邻边以后就可以很方便地得到。
     *
     * 这里回答一下使用队列的问题，如果不使用队列，要想得到当前入度为 00 的结点，就得遍历一遍入度数组。使用队列即用空间换时间。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        // 邻接表
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        // 节点的入度
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            ++inDegree[prerequisites[i][0]];
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // 首先加入所有入度为0的节点
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.push(i);
        }

        int cnt = 0;

        while(!queue.isEmpty()) {
            int idx = queue.poll();
            ++cnt;
            List<Integer> list = graph.get(idx);
            for (int i = 0; i < list.size(); i++) {
                if (--inDegree[list.get(i)] == 0) queue.push(list.get(i));
            }
        }

        return cnt == numCourses;
    }



}
