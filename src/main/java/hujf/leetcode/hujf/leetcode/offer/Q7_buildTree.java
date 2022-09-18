package hujf.leetcode.hujf.leetcode.offer;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 *  
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q7_buildTree {

    public static void main(String[] args) {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        TreeNode t = new Q7_buildTree().buildTree(preorder, inorder);
        System.out.println(t);
    }

    /**
     * 迭代法（即模拟递归法）TODO
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; ++i) {

        }
        return null;
    }

    /**
     * 递归法
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);

    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preOrderStart, int preOrderEnd, int inorderStart, int inorderEnd) {
        if (preOrderStart >= preOrderEnd) {
            return null;
        }
        int num = 0;
        for (int i = inorderStart; i < inorderEnd; ++i) {
            if (inorder[i] == preorder[preOrderStart]) {
                num = i - inorderStart;
                break;
            }
        }

        TreeNode treeNode = new TreeNode(preorder[preOrderStart]);
        treeNode.left = buildTree(preorder, inorder,
                preOrderStart + 1, preOrderStart + 1 + num,
                inorderStart, inorderStart + num);
        treeNode.right = buildTree(preorder, inorder,
                preOrderStart + 1 + num, preOrderEnd,
                inorderStart + num + 1, inorderEnd);
        return treeNode;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



}
