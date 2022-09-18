package hujf.leetcode.hujf.leetcode.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Q11_minArray {

    public static void main(String[] args) {
        System.out.println(
                new Q11_minArray().minArray(new int[] {2, 2, 2, 0, 1})
        );
    }

    /**
     * 迭代二分法
     */
    public int minArray2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int s = 0, e = numbers.length - 1;
        while (s < e) {
            int m = (s + e) / 2;
            if (numbers[m] < numbers[e]) {
                e = m;
            } else if (numbers[m] > numbers[e]) {
                s = m + 1;
            } else {
                --e;
            }
        }
        return numbers[e];
    }

    /**
     * 递归二分剪枝法
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        return numbers[minArray(numbers, 0, numbers.length - 1)];
    }

    private int minArray(int[] numbers, int s, int e) {
        if (s == e) {
            return e;
        }
        if (numbers[s] < numbers[e]) {
            return s;
        }
        int m = (s + e) / 2;
        int l = minArray(numbers, s, m);
        int r = minArray(numbers, m + 1, e);
        return numbers[l] < numbers[r] ? l : r;

    }


}
