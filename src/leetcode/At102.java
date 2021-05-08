package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class At102 {

    public static void main(String[] args) {
        levelOrder2(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));

    }

    /**
     * 双队列，不过我感觉可以优化
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (root == null) return listList;
        // 这里的两个队列可以合并成一个，可以通过现有的queue的数据结构知道当前queue的大小
        // 所以对于当前层的结点个数是已知的，就不用纠结于频繁的clear和addAll了，整体上空间和时间都优化了。
        // 看levelOrder2具体实现吧
        Queue<TreeNode> getQueue = new ArrayDeque<>();
        Queue<TreeNode> pushQueue = new ArrayDeque<>();
        getQueue.add(root);
        while (!getQueue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            getQueue.forEach(tempNode -> {
                list.add(tempNode.val);
                if (tempNode.left != null) pushQueue.add(tempNode.left);
                if (tempNode.right != null) pushQueue.add(tempNode.right);
            });
            listList.add(list);
            getQueue.clear();
            getQueue.addAll(pushQueue);
            pushQueue.clear();
        }
        return listList;
    }

    /**
     * levelOrder的优化
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if (root == null) return listList;
        // 这里的两个队列可以合并成一个，可以通过现有的queue的数据结构知道当前queue的大小
        // 所以对于当前层的结点个数是已知的，就不用纠结于频繁的clear和addAll了，整体上空间和时间都优化了。
        // 看levelOrder2具体实现吧
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tempNode = queue.remove();
                list.add(tempNode.val);
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
            }
            listList.add(list);
        }
        return listList;
    }

}
