package hujf.leetcode.offer;

import hujf.leetcode.annotation.Highlight;
import hujf.leetcode.annotation.WithAnswer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * <p>
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
@WithAnswer
@Highlight
public class Q37_Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        Q37_Codec q37_codec = new Q37_Codec();
        q37_codec.deserialize(q37_codec.serialize(root));
    }

    /**
     * BFS，因为有负数，所以不能用字符，只能用字符串
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            sb.append('#');
            sb.append(convert(node.left));
            sb.append('#');
            sb.append(convert(node.right));
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] ss = data.split("#");
        TreeNode root = convert(ss[0]);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int i = 1;
        while (!deque.isEmpty()) {
            TreeNode parent = deque.poll();
            TreeNode left = i < data.length() ? convert(ss[i++]) : null;
            TreeNode right = i < data.length() ? convert(ss[i++]) : null;
            parent.left = left;
            parent.right = right;
            if (left != null) {
                deque.offer(left);
            }
            if (right != null) {
                deque.offer(right);
            }
        }
        return root;
    }

    private TreeNode convert(String s) {
        if (s.equals("?")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }

    private String convert(TreeNode n) {
        if (n == null) {
            return "?";
        } else {
            return String.valueOf(n.val);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
