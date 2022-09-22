package hujf.leetcode.offer;

import hujf.leetcode.annotation.WithAnswer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *  
 *
 * 提示：
 *
 * 数组长度 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
@WithAnswer
public class Q33_verifyPostorder {

    /**
     * 递归法的核心思路是"左右根"，也就是说最后一个节点一定是根节点，然后就可以递归了
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int s, int e) {
        if (s >= e) {
            return true;
        }
        int m = s;
        while (m < e && postorder[m] < postorder[e]) {
            ++m;
        }
        int t = m;
        while (t < e && postorder[t] > postorder[e]) {
            ++t;
        }
        return t == e && recur(postorder, s, m - 1) && recur(postorder, m, e - 1);
    }

}
