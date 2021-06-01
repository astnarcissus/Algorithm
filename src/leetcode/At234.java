package leetcode;

import leetcode.common.ListNode;

import javax.jnlp.ClipboardService;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class At234 {

    public static void main(String[] args) {
        System.out.println(new At234().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
    }

    /**
     * 快慢指针，找到中点
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = head;
        ListNode cur2 = reverseNode(slow.next);
        slow.next = null;
        while (cur != null && cur2 != null) {
            if (cur.val != cur2.val) return false;
            cur = cur.next;
            cur2 = cur2.next;
        }
        if (cur == null && cur2 == null || cur != null && cur.next == null && cur2 == null) return true;
        return false;
    }

    public ListNode reverseNode(ListNode head) {
        ListNode nodeHead = new ListNode();
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = nodeHead.next;
            nodeHead.next = tmp;
        }
        return nodeHead.next;
    }

}
