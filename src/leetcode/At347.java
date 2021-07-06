package leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 */
public class At347 {

    public static void main(String[] args) {
        new At347().topKFrequent(new int[]{1,1,1,5,5,5,5,2,2,3},2);
    }

    /**
     * 用了两种数据结构，效率似乎有点慢，空间复杂度也有点高
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) hashMap.put(num, hashMap.get(num) + 1);
            else hashMap.put(num, 0);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    /**
     * 优先队列（堆）
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        priorityQueue.addAll(hashMap.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = priorityQueue.poll().getKey();
        }
        return res;
    }

}
