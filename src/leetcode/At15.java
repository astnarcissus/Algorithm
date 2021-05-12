package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 */
public class At15 {

    public static void main(String[] args) {
        System.out.println(new At15().threeSum2(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 正解
     * 排序 + 双指针
     * 思路是摘得，代码是自己实现的
     *
     * 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     * 对数组进行排序。
     * 遍历排序后数组：
     * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R移到下一位置，寻找新的解
     * 若和大于 0，说明 nums[R]nums[R] 太大，R 左移
     * 若和小于 0，说明 nums[L]nums[L] 太小，L 右移
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        if (n < 3) return lists;
        for (int i = 0; i < n - 2; ) {
            if (nums[i] > 0) break;
            int x = i + 1;
            int y = n - 1;
            while (x < y) {
                if (nums[i] + nums[x] + nums[y] == 0) {
//                    if (x > i + 1 && nums[x - 1] == nums[x]) {
//                        x++;
//                        continue;
//                    }
//                    if (y < n - 1 && nums[y] == nums[y + 1]) {
//                        y--;
//                        continue;
//                    }
                    // 上面代码的优化
                    lists.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    while (x < y && nums[x + 1] == nums[x]) x++;
                    while (x < y && nums[y - 1] == nums[y]) y--;
                    x++;
                    y--;
                } else if (nums[i] + nums[x] + nums[y] > 0) {
                    y--;
                } else if (nums[i] + nums[x] + nums[y] < 0) {
                    x++;
                }
            }
            while (i < n - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
            i++;
        }
        return lists;
    }

    /**
     * 诶，超时了，妈的
     * 不过基本求子集的问题确实都基本可以通过dfs来求解呢
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return lists;
        dfs(0, 0, new ArrayList<>(), n, nums, lists);
        return lists;
    }

    /**
     * 感觉应该没问题，不过超时了，应该是应该是树的高度太高了
     *
     * @param cur
     * @param selectedSize
     * @param selectedList
     * @param n
     * @param nums
     * @param lists
     */
    public void dfs(int cur, int selectedSize, List<Integer> selectedList, int n, int[] nums, List<List<Integer>> lists) {
        if (selectedSize == 3) {
            if (selectedList.get(0) + selectedList.get(1) + selectedList.get(2) == 0) {
                boolean existFlg = false;
                for (List<Integer> list : lists) {
                    if (list.containsAll(selectedList)) {
                        existFlg = true;
                    }
                }
                if (!existFlg) lists.add(new ArrayList<>(selectedList));
            }
        }
        if (cur == n) {
            return;
        }
        selectedList.add(nums[cur]);
        dfs(cur + 1, selectedSize + 1, selectedList, n, nums, lists);
        selectedList.remove(selectedList.size() - 1);
        dfs(cur + 1, selectedSize, selectedList, n, nums, lists);
    }

}
