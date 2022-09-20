package hujf.leetcode.offer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q29_spiralOrder {

    /**
     * 模拟
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] ret = new int[matrix.length * matrix[0].length];
        int[][] flag = new int[matrix.length][matrix[0].length];

        int retI = 0;
        int i = 0, j = 0;
        while (retI < ret.length) {
            while (j < matrix[0].length && flag[i][j] == 0) {
                ret[retI] = matrix[i][j];
                ++retI;
                flag[i][j] = 1;
                ++j;
            }
            --j;
            ++i;
            while (i < matrix.length && flag[i][j] == 0) {
                ret[retI] = matrix[i][j];
                ++retI;
                flag[i][j] = 1;
                ++i;
            }
            --i;
            --j;
            while (j >= 0 && flag[i][j] == 0) {
                ret[retI] = matrix[i][j];
                ++retI;
                flag[i][j] = 1;
                --j;
            }
            ++j;
            --i;
            while (i >= 0 && flag[i][j] == 0) {
                ret[retI] = matrix[i][j];
                ++retI;
                flag[i][j] = 1;
                --i;
            }
            ++i;
            ++j;
        }
        return ret;
    }

}
