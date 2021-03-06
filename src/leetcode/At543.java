package leetcode;

import leetcode.common.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 */
public class At543 {

    public static void main(String[] args) {

    }

    int maxRoute;

    public int diameterOfBinaryTree(TreeNode root) {
        maxRoute = 1;
        getHigh(root);
        return maxRoute - 1;
    }

    public int getHigh(TreeNode root) {
        if (root == null) return 0;
        int leftHigh = getHigh(root.left);
        int rightHigh = getHigh(root.right);
        maxRoute = Math.max(maxRoute, leftHigh + rightHigh + 1);
        return Math.max(leftHigh, rightHigh) + 1;
    }

}
