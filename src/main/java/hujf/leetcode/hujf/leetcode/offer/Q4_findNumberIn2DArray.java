package hujf.leetcode.hujf.leetcode.offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *  
 *
 * 限制：
 *
 * 0 <= n <= 1000
 *
 * 0 <= m <= 1000
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q4_findNumberIn2DArray {

    public static void main(String[] args) {
        int array[][] ={{0,0,0},{2,7,9},{7,8,11}};
        int target = 7;
        System.out.println(new Q4_findNumberIn2DArray().findNumberIn2DArray(array, target));
    }

    /**
     * 二叉查找法，可以把二维数组左旋45度，即可看到右上角度元素是根结点，左边的都小，右边都都大
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    /**
     * 循环模拟法
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        int m = n == 0 ? 0 : matrix[0].length;
        int i = 0;
        int j = 0;
        int flag[][] = new int[n][m];
        while (i < n && j < m) {
            if (matrix[i][j] == target) {
                return true;
            }
            flag[i][j] = 1;
            if (j + 1 < m && flag[i][j + 1] == 0 && matrix[i][j + 1] <= target) {
                ++j;
                continue;
            }
            if (i + 1 < n && flag[i + 1][j] == 0 && matrix[i + 1][j] <= target) {
                ++i;
                continue;
            }
            if (j - 1 >= 0 && matrix[i][j - 1] <= target) {
                --j;
                continue;
            }
            if (i - 1 >= 0 && matrix[i - 1][j] <= target) {
                --i;
                continue;
            }
            return false;
        }
        return false;
    }

}
