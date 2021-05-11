package leetcode;

import leetcode.common.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 */
public class At114 {

    public static void main(String[] args) {
//        new At114().flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6))));

    }

    /**
     * 妈的一把过了，真爽
     * 基本就是寻找前驱结点的思路
     * 不过还是有点冗长了，有机会可以优化一下代码
     *
     * @param root
     */
    public void flatten(TreeNode root) {

        TreeNode pre = root;
        if (pre == null) {
            return;
        }

        // 没有左节点，没有右节点，结束
        while (pre.left != null || pre.right != null) {
            // 没有左节点，有右节点，不操作
            if (pre.left == null) {
                pre = pre.right;
            }
            // 有左节点，没有右节点，吧左节点变成右节点
            else if (pre.right == null) {
                pre.right = pre.left;
                pre.left = null;
                pre = pre.right;
            }
            // 有左节点，有右节点，左节点变成右节点，右节点变成左节点的最右子节点
            else {
                TreeNode cur = pre.left;
                while(cur.right != null) {
                    cur = cur.right;
                }
                cur.right = pre.right;
                pre.right = pre.left;
                pre.left = null;
                pre = pre.right;
            }
        }
    }

}
