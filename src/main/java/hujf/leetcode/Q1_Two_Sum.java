package hujf.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 */
public class Q1_Two_Sum {

    public static void main(String[] args) {

    }

    /**
     * 解法1：空间换时间，建立key为 num ，value为num下标的哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> restToIndex = new HashMap<>();
        restToIndex.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int rest = target - nums[i];
            Integer index = restToIndex.get(rest);
            if (index != null) {
                return new int[] {index, i};
            } else {
                restToIndex.put(nums[i], i);
            }
        }
        return null;
    }

    //解法2：两层循环，暴力破解，此处略去

}
