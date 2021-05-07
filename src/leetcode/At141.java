package leetcode;

import leetcode.common.ListNode;

import javax.jnlp.ClipboardService;
import java.util.HashSet;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class At141 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode;
        System.out.println(hasCycle(listNode));
    }

    /**
     * 暴力
     * 用哈希表记录是否走过路径，不过空间复杂度不符合题目要求
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针，这倒是我第一次接触的概念，不过空间复杂度确实小了，有点意思
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
