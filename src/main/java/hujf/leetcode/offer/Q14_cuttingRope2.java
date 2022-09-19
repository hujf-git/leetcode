package hujf.leetcode.offer;

import java.math.BigInteger;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *  
 *
 * 提示：
 *
 * 2 <= n <= 1000
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 搞不定
 */
public class Q14_cuttingRope2 {

    public int cuttingRope(int n) {
        BigInteger[] max = new BigInteger[n + 1];
        max[1] = BigInteger.valueOf(1);
        max[2] = BigInteger.valueOf(1);
        for (int i = 3; i < n + 1; ++i) {
            max[i] = BigInteger.valueOf(0);
            for (int j = 1; j < i; ++j) {
                BigInteger v = BigInteger.valueOf(j).multiply(max[i - j].max(BigInteger.valueOf(i - j)));
                if (max[i].max(v).equals(v)) {
                    max[i] = v;
                }
            }
        }
        return max[n].remainder(BigInteger.valueOf(1000000007)).intValue();
    }

}
