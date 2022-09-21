package hujf.leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q32_II_levelOrder {

    /**
     * 2个辅助队列 + BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> queueOfNode = new ArrayDeque<>();
        queueOfNode.offer(root);
        Deque<Integer> queueOfLevel = new ArrayDeque<>();
        queueOfLevel.offer(0);

        List<List<Integer>> ret = new ArrayList<>();
        while (!queueOfNode.isEmpty()) {
            TreeNode node = queueOfNode.poll();
            Integer level = queueOfLevel.poll();
            if (ret.size() < level + 1) {
                ret.add(new ArrayList<>());
            }
            List<Integer> levelList = ret.get(level);
            levelList.add(node.val);
            if (node.left != null) {
                queueOfNode.offer(node.left);
                queueOfLevel.offer(level + 1);
            }
            if (node.right != null) {
                queueOfNode.offer(node.right);
                queueOfLevel.offer(level + 1);
            }
        }
        return ret;
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
