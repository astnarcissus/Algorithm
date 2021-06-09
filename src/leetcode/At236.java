package leetcode;

import leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */
public class At236 {

    /**
     * 原本有一个想法是将root，p，q化为前序遍历的字符串的，不过这样一通乱操作，加上匹配字符串，好像有点得不偿失
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    /**
     * 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null ；
     * 当 left 和 right 同时不为空 ：说明 p, q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root 为最近公共祖先，返回 root ；
     * 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
     *      p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
     *      p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
     * 当 left 不为空 ， right 为空 ：与情况 3. 同理；
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        return null;
    }

}
