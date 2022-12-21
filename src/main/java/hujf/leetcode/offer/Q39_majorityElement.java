package hujf.leetcode.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 */
public class Q39_majorityElement {

    public static void main(String[] args) {

    }

    /**
     * 哈希计数 & 排序取中位数 都简单
     * 摩尔投票法比较难想到
     */
    public int majorityElement(int[] nums) {
        int v = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (sum == 0) {
                v = nums[i];
                ++sum;
                continue;
            }
            if (nums[i] == v) {
                ++sum;
            } else {
                --sum;
            }
        }
        return v;
    }


}
