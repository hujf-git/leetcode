package hujf.leetcode.hujf.leetcode.offer;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 可用于笔试
 */
public class Q12_exist {

    /**
     * 递归法
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.isEmpty()) {
            return true;
        }
        int[][] cache = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (exist(board, i, j, word, cache)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int r, int c, String word, int[][] cache) {
        if (word.isEmpty()) {
            return true;
        }
        if (r < 0 || r >= board.length
                || c < 0 || c >= board[0].length
                || cache[r][c] == 1
                || board[r][c] != word.charAt(0)) {
            return false;
        }
        cache[r][c] = 1;
        boolean ret = exist(board, r - 1, c, word.substring(1), cache)
                || exist(board, r + 1, c, word.substring(1), cache)
                || exist(board, r, c - 1, word.substring(1), cache)
                || exist(board, r, c + 1, word.substring(1), cache);
        cache[r][c] = 0;
        return ret;
    }

}
