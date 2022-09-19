package hujf.leetcode.offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q21_exchange {

    /**
     * 快慢指针法
     */
    public int[] exchange2(int[] nums) {
        if (nums == null) {
            return null;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 0) {
                ++fast;
            } else {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                ++slow;
                ++fast;
            }
        }
        return nums;
    }

    /**
     * 首尾指针法
     */
    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int p = 0, q = nums.length - 1;
        while (p <= q) {
            if (nums[p] % 2 == 1) {
                ++p;
            } else if (nums[q] % 2 == 0) {
                --q;
            } else {
                int tmp = nums[p];
                nums[p] = nums[q];
                nums[q] = tmp;
            }
        }
        return nums;
    }

}
