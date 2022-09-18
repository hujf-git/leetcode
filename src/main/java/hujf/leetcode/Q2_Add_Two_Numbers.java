package hujf.leetcode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class Q2_Add_Two_Numbers {

    /**
     * 解法1：定义一个进位符C，当C和两数相加>9时，置为1，否则置为0；因为要正序，所以要采用尾插法
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ret.val = (l1.val + l2.val) % 10;
        ret.next = null;
        int c = (l1.val + l2.val) / 10;

        ListNode p = ret;
        while (l1.next != null) {
            if (l2.next != null) {
                int sum = c + l1.next.val + l2.next.val;
                p.next = new ListNode();
                p.next.val = sum % 10;
                p.next.next = null;
                c = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
                p = p.next;
            } else {
                int sum = c + l1.next.val;
                p.next = new ListNode();
                p.next.val = sum % 10;
                p.next.next = null;
                c = sum / 10;
                l1 = l1.next;
                p = p.next;
            }
        }
        while (l2.next != null) {
            int sum = c + l2.next.val;
            p.next = new ListNode();
            p.next.val = sum % 10;
            p.next.next = null;
            c = sum / 10;
            l2 = l2.next;
            p = p.next;
        }
        if (c != 0) {
            p.next = new ListNode();
            p.next.val = c;
        }

        return ret;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}


