package leetcode_zj100.offer18;

/**
 * @author shengyi
 * @create 2021/8/20 - 0:03
 * ok
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = null;
        ListNode n = null;
        node = head;
        if (head.val == val) {
            return head.next;
        }
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                return node;
            }
            head = head.next;
        }
        return node;
    }
}
