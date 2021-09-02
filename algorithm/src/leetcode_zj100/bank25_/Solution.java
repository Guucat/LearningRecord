package leetcode_zj100.bank25_;

/**
 * @author shengyi
 * @create 2021/8/20 - 0:10
 * not ok
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode tem1 = null;
        ListNode tem2 = null;
        ListNode l_node1 = null;
        ListNode l_node2;
        int nodes = 0;
        int zk = k;
        ListNode r_head = null;
        while (temp != null) {
            temp = temp.next;
            nodes++;
        }
        int n = nodes % k;
        //翻转次数
        int N = nodes/k;
            while (N != 0) {
                tem1 = tok(head, zk);
                if (r_head == null) {
                    r_head = tem1;
                    tem2 = r_head;
                } else {

                    for (int i =0; i < k  - 1; i++) {
                        tem2 = tem2.next;
                    }
                    tem2.next = tem1;
                }
                //裁剪
                N--;
                zk+=k;
            }
        return r_head;
    }

    public ListNode tok(ListNode head, int k) {
        int i = k;
        ListNode theK = null;
        ListNode tmp1;
        ListNode s_head = null;
        while (i > 0) {
            ListNode blo = head;
            for (int j = 0; j < i-1; j++) {
                blo = blo.next;
            }
            tmp1 = blo;
            if (theK == null) {
                theK = new ListNode(blo.val);
                s_head = theK;
            } else {
                s_head.next = new ListNode(tmp1.val);
                s_head = s_head.next;
            }
            i--;
        }
        ListNode blo = head;
        for (i = 0; i<k; i++){
            blo = blo.next;
        }
        s_head.next = blo;

        return theK;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println("NOT");
    }

}
