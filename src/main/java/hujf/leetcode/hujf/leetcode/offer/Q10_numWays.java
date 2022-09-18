package hujf.leetcode.hujf.leetcode.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 0: 1
 * 1: 1
 * 2: 2
 * 3: 3
 * 4: 5
 * 5: 8
 * 6: 13
 * 7: 21
 *
 */
public class Q10_numWays {

    public static void main(String[] args) {
        System.out.println(new Q10_numWays().numWays(7));
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % 1000000007;
        }
        return cache[n];
    }
}
