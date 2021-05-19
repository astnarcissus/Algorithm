package leetcode;

import leetcode.common.ListNode;

import java.util.List;

/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 */
public class At148 {

    public static void main(String[] args) {
        ListNode node = new At148().sortList2(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3)))));
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }

    /**
     * 好说歹说也算是一种解法是不是
     * 简而言之就是中间砍一刀，然后后面的向前面的插
     * 类似插入排序？
     * 时间复杂度是O(n²)呢，诶
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        head = newHead;
        ListNode cur = head.next.next;
        head.next.next = null;
        // O(N)
        while (cur != null) {
            ListNode pre = head;
            ListNode cur2 = head.next;
            // O(n)
            while (cur2 != null && cur.val > cur2.val && cur != cur2) {
                cur2 = cur2.next;
                pre = pre.next;
            }
            ListNode tempNode = cur;
            cur = cur.next;
            tempNode.next = pre.next;
            pre.next = tempNode;
        }
        return head.next;
    }


    /**
     * 所以真正的解法是归并喽。
     * 那么怎么寻找链表的终点呢，快慢指针，牛逼啊，真是绝了。
     *
     * 这个是自顶向上的，题解还有一种解法，先存着
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        return sortList2(head, null);
    }


    public ListNode sortList2(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != tail) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortList2(head, mid);
        ListNode list2 = sortList2(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;

    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }


}
