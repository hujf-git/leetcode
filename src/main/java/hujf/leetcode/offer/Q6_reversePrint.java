package hujf.leetcode.offer;

import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1 -> 2 -> 3 -> 4
 */
public class Q6_reversePrint {

    /**
     * 反转链表法
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int num = 0;
        ListNode pre = null;
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
            num++;
        }
        head = pre;
        int[] ret = new int[num];
        for (int i = 0; i < num; ++i) {
            ret[i] = head.val;
            head = head.next;
        }
        return ret;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
