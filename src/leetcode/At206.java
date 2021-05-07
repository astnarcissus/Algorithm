package leetcode;

import leetcode.common.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 */
public class At206 {

    public static void main(String[] args) {





    }

    /**
     * 简简单单的翻转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        head = new ListNode();
        while(cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = head.next;
            head.next = temp;
        }
        return head.next;
    }

}
