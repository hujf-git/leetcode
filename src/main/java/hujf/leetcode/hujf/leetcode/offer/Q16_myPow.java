package hujf.leetcode.hujf.leetcode.offer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *  
 * <p>
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q16_myPow {

    /**
     * 二分迭代法, TODO
     */
    public double myPow3(double x, int n) {
        return 0;
    }

    /**
     * 二分递归法
     */
    public double myPow2(double x, int n) {
        if (n < 0) {
            //要考虑边界情况
            return 1.0/ x / _myPow2(x, - (n + 1) );
        } else {
            return _myPow2(x, n);
        }
    }

    private double _myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            double v = _myPow2(x, n / 2);
            return  v * v * x;
        } else {
            double v = _myPow2(x, n / 2);
            return v * v;
        }
    }


    /**
     * 暴力法，超时了
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n > 0) {
            double r = x;
            while (--n != 0) {
                r *= x;
            }
            return r;
        } else {
            double r = x;
            while (++n != 0) {
                r *= x;
            }
            return 1.0 / r;
        }
    }

}
