package leetcode;

import leetcode.common.TreeNode;

/**
 * @author: 言叶长琴
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 *   /  \
 *  15   7
 * 返回它的最大深度3 。
 */
public class At104 {
    public static void main(String[] args) {
        System.out.println(maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    /**
     * 好，和题解一样，不愧是简单题啊233
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}

