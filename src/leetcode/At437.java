package leetcode;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class At437 {

    public static void main(String[] args) {
        System.out.println(new At437().pathSum2(new TreeNode(0, new TreeNode(1), new TreeNode(1)), 1));
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int res = dfs(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int dfs(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == targetSum)
            ++res;

        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
    }

    // 前缀和
    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        // key为前缀和， value为前缀和出现的次数（类似路径）
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return dfs(root, prefixSumCount, targetSum, 0);
    }

    public int dfs(TreeNode root, Map<Integer, Integer> prefixSumCount, int targetSum, int currSum) {
        if (root == null)
            return 0;

        int res = 0;

        currSum += root.val;

        res += prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // 这里需要注意的是可能前缀和都为0
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        res += dfs(root.left, prefixSumCount, targetSum, currSum);
        res += dfs(root.right, prefixSumCount, targetSum, currSum);

        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return res;
    }

}
