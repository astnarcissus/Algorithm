package leetcode;

import leetcode.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class At155 {

}

/**
 * 需要常数时间内获得最小值
 */
class MinStack {

    class ListNode {
        int val;
        ListNode next;
        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        head = null;
    }

    public void push(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    public void pop() {
        if (head != null) head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        int min = head.val;
        ListNode cur = head.next;
        while(cur != null) {
            if (min > cur.val) min = cur.val;
            cur = cur.next;
        }
        return min;
    }
}

class MinStack2 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack2() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
