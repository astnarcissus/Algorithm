package leetcode;

import leetcode.common.ListNode;

/**
 *
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 */
public class At142 {

    public static void main(String[] args) {

    }

    /**
     * 这题需要一点数学功底，妈的
     *
     * 双指针第一次相遇： 设两指针 fast，slow 指向链表头部 head，fast 每轮走 2步，slow 每轮走 1步；
     *
     * 第一种结果： fast 指针走过链表末端，说明链表无环，直接返回 null；
     *
     * TIPS: 若有环，两指针一定会相遇。因为每走 1轮，fast 与 slow 的间距 +1，fast 终会追上 slow；
     *
     * 第二种结果： 当fast == slow时， 两指针在环中 第一次相遇 。下面分析此时fast 与 slow走过的 步数关系 ：
     *
     * 设链表共有 a+b 个节点，其中 链表头部到链表入口 有 a 个节点（不计链表入口节点）， 链表环 有 b 个节点
     * （这里需要注意，a 和 b 是未知数，例如链表 a=4 , b=5）；设两指针分别走了 f，s 步，则有：
     * fast 走的步数是slow步数的 2倍，即 f = 2s；（解析： fast 每轮走 2 步）
     * fast 比 slow多走了 n 个环的长度，即 f = s + nb；
     * （ 解析： 双指针都走过 a 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）；
     * 以上两式相减得：f = 2nb，s = nb，即fast和slow 指针分别走了 2n，n 个 环的周长
     * （注意： n 是未知数，不同链表的情况不同）。
     * 目前情况分析：
     *
     * 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：k=a+nb
     * （先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点）。
     * 而目前，slow 指针走过的步数为 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。
     * 但是我们不知道 a 的值，该怎么办？
     * 依然是使用双指针法。我们构建一个指针，此指针需要有以下性质：
     * 此指针和slow 一起向前走 a 步后，两者在入口节点重合。那么从哪里走到入口节点需要 a 步？答案是链表头部head。
     * 双指针第二次相遇：
     *
     * slow指针 位置不变 ，将fast指针重新 指向链表头部节点 ；slow和fast同时每轮向前走 1 步；
     * TIPS：此时 f = 0，s = nb ；
     * 当 fast 指针走到f = a 步时，slow 指针走到步s = a+nb，此时 两指针重合，并同时指向链表环入口 。
     * 返回slow指针指向的节点。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 此处也可以将fast指向head再利用
                ListNode cur = head;
                while(slow != cur) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }

        return null;
    }

}
