package hujf.leetcode;

/**
 * https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * ErrorHard
 */
public class Q4_Median_of_Two_Sorted_Arrays {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1,2,3,4,5,6};
        System.out.println(new Q4_Median_of_Two_Sorted_Arrays().findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 对两个数组分别二分，每次二分都可以干掉两个数组更小的那个数的左边的数字，
     * 直到被干掉的数量等于两个数组长度之和的一半
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并后数组的长度的一半需要排掉的数量
        int half = (nums1.length + nums2.length - 1) / 2;
        // 序列1中被干掉的数量
        int half1 = 0;
        // 序列2中被干掉的数量
        int half2 = 0;

        while (half1 + half2 != half) {
            if (half1 < nums1.length && half2 < nums2.length) {
                if (nums1[half1] < nums2[half2]) {
                    if (half1 + half2 < half) {
                        half1 = (half1 + nums1.length) / 2;
                    } else {
                        half2 = half2 / 2;
                    }
                } else {
                    if (half1 + half2 < half) {
                        half2 = (half2 + nums2.length) / 2;
                    } else {
                        half1 = half1 / 2;
                    }
                }
            } else if (half1 < nums1.length) {
                if (half1 + half2 < half) {
                    half1 = (half1 + nums1.length) / 2;
                } else {
                    half1 = half1 / 2;
                }
            } else {
                if (half1 + half2 < half) {
                    half2 = (half2 + nums2.length) / 2;
                } else {
                    half2 = half2 / 2;
                }
            }
        }

        if ((nums1.length + nums2.length) % 2 == 1) {
            //如果是奇数
            if (half1 < nums1.length && half2 < nums2.length) {
                return nums1[half1] < nums2[half2] ? nums1[half1] : nums2[half2];
            } else if (half1 < nums1.length) {
                return nums1[half1];
            } else {
                return nums2[half2];
            }
        } else {
            if (half1 < nums1.length && half2 < nums2.length) {
                return (nums1[half1] + nums2[half2]) / 2.0;
            } else if (half1 < nums1.length) {
                return (nums1[half1] + nums1[half1 + 1]) / 2.0;
            } else {
                return (nums2[half2] + nums2[half2 + 1]) / 2.0;
            }
        }

    }


}
