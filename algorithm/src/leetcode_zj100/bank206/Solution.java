package leetcode_zj100.bank206;

/**
 * @author shengyi
 * @create 2021/8/26 - 20:05
 * easy
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode (int val) {
            this.val = val;
        }
        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode tem = null;
        while (head != null) {
            newHead.next = head;
            head = head.next;
            newHead.next.next = tem;
            tem = newHead.next;

        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode c = new ListNode(3);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        System.out.println(a.val);
        ListNode d = solution.reverseList(a);

        System.out.println(d.next.val);
    }
}
