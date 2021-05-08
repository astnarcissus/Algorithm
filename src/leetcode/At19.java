package leetcode;

import leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class At19 {

    public static void main(String[] args) {

    }

    /**
     * 一趟扫描，那不就是空间换时间么，当时的想法，准备看看题解做和说明
     * 过倒是也过了
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode cur = new ListNode();
        cur.next = head;
        head = cur;
        while (cur != null) {
            listNodes.add(cur);
            cur = cur.next;
        }
        int size = listNodes.size();
        listNodes.get(size - n - 1).next = listNodes.get(size - n).next;
        return head.next;
    }

    /**
     * 官方题解的第一个就是常规的遍历两次，第一次取长度，第二次截取
     * 第二个题解用的栈，和我的第一个解法倒是差不多，基本也是空间换时间
     * 第三个是快慢指针，也是这个方法的解法
     *
     * 值得注意的是在头上加一个空节点作头，可以减少不少繁琐的判断
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newHead = new ListNode(0,head);
        ListNode slow = newHead;
        ListNode fast = newHead;
        for(int i = 0;i<n;i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }

}
