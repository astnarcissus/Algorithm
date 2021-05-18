package leetcode;

import leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class At98 {

    public static void main(String[] args) {
        System.out.println(new At98().isValidBST(new TreeNode(1, new TreeNode(1), null)));
        System.out.println(new At98().isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

    }


    /**
     * 普通的中序遍历当然也可以
     * morris 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        long preVal = Long.MIN_VALUE;
        while (cur != null) {
            // 如果有左孩子
            System.out.println("cur.val = " + cur.val);
            if (cur.left != null) {
                pre = cur.left;
                // 找到最右节点
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                // 如果第一次遍历到最右节点，则将当前节点连接到最右节点的右节点上
                // 有点绕，简而言之，找到cur的前驱结点
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }
                // 如果没有左节点，则右移
                else {
                    if (preVal >= cur.val) return false;
                    preVal = (long)cur.val;
                    cur = cur.right;
                    pre.right = null;
                }
            }
            // 如果没有左孩子，判断，并又移
            else {
                if (preVal >= cur.val) return false;
                preVal = (long)cur.val;
                cur = cur.right;
            }
        }
        return true;
    }

}
