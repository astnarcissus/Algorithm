package leetcode;

import leetcode.common.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class At101 {

    public static void main(String[] args) {
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
        System.out.println(isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)))));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSame(root.left, root.right);
    }

    /**
     * 递归啊，不愧是简单题
     * @param left
     * @param right
     * @return
     */
    public static boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
