package leetcode_zj100.bank92;

/**
 * @author shengyi
 * @create 2021/9/1 - 10:40
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     *需要四个结点记录:
     * left 前一个结点
     * right 后一个结点
     *  left 和 right 结点通过它们对链表翻转
     *  反转时需要 三个结点:
     *  辅助翻转的头结点，它的下一个结点是 right 结点
     *  在 left 到 right 间逐一变化的结点
     *  记录 ListNode(int val, ListNode next) 中 next结点的值，即上一个翻转的结点
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int n = 1;
        // left位置上一个结点
        ListNode lb = null;
        // left位置的结点
        ListNode l;
        // right位置下一个的结点
        ListNode rn;
        // right位置的结点
        ListNode r;
        ListNode tem = head;
        if (left == 1) {
            for (int i = 1; i < right; i++) {
                tem = tem.next;
            }
            //辅助翻转的头结点
            ListNode newNode = new ListNode();
            //此时 next 为right下一个结点
            ListNode next = tem;
            tem = head;
            int m = 0;
            while (m < right - left + 1) {
                newNode.next = new ListNode(tem.val, next);
                next = newNode.next;
                tem = tem.next;
                m++;
            }
            return newNode.next;
        }
        while (n != right) {
            if (n == left - 1) {
                lb = tem;
                l = tem.next;
            }
            tem = tem.next;
            n++;
        }
        r = tem;
        rn = tem.next;
        tem = lb;
        ListNode last = rn;
        // r 为 right 结点
        while (tem != r) {
            tem  = tem.next;
            lb.next = new ListNode(tem.val, last);
            last = lb.next;
        }

        tem.next = rn;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, null);
        Solution solution = new Solution();
        solution.reverseBetween(listNode, 1 , 1);
    }

}
