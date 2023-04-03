package hujf.leetcode.offer;

import hujf.leetcode.annotation.Highlight;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
@Highlight
public class Q40_getLeastNumbers {

    public static void main(String[] args) {
        new Q40_getLeastNumbers().getLeastNumbers3(new int[] {4,3,2,9,7,6,0,2,8,5},4);
    }

    /**
     * Java内置快排
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    /**
     * 手撸快排 交换法  4329760285
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length > 1) {
            quicksort(arr, 0, arr.length - 1);
        }
        return Arrays.copyOf(arr, k);
    }

    /**
     * 手撸快排 挖坑法  4329760285
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length > 1) {
            quicksort2(arr, 0, arr.length - 1);
        }
        return Arrays.copyOf(arr, k);
    }

    /**
     * 手撸快排 快慢指针法  4329760285
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr.length > 1) {
            quicksort3(arr, 0, arr.length - 1);
        }
        return Arrays.copyOf(arr, k);
    }

    /**
     * 交换
     */
    private void quicksort2(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int p = s;
        int q = e;
        while (p < q) {
            while (p < q && arr[q] >= arr[s]) {
                --q;
            }
            while (p < q && arr[p] <= arr[s]) {
                ++p;
            }
            if (p < q) {
                swap(arr, p, q);
            }
        }
        swap(arr, p, s);
        quicksort2(arr, s, p - 1);
        quicksort2(arr, q + 1, e);
    }

    /**
     * 挖坑
     */
    private void quicksort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int p = s;
        int q = e;
        while (p < q) {
            while (p < q && arr[q] > arr[p]) {
                --q;
            }
            if (arr[q] <= arr[p]) {
                swap(arr, p, q);
            }
            while (p < q && arr[p] <= arr[q]) {
                ++p;
            }
            if (arr[p] > arr[q]) {
                swap(arr, p, q);
            }
        }
        quicksort(arr, s, p - 1);
        quicksort(arr, q + 1, e);
    }

    /**
     * 单指针
     */
    private void quicksort3(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }
        int p = s;
        int q = e;
        int pivot = arr[s];
        int markPoint = s;

        for (int i = s + 1; i <= e; i++) {
            // 如果比分界值小，则 mark++ 后互换。
            if (arr[i] < pivot) {
                markPoint++;
                int temp = arr[markPoint];
                arr[markPoint] = arr[i];
                arr[i] = temp;
            }
        }
        // 将首元素分界值与当前mark互换
        arr[s] = arr[markPoint];
        arr[markPoint] = pivot;
        quicksort3(arr, s, p - 1);
        quicksort3(arr, q + 1, e);
    }

    private void swap(int[] arr, int p, int q) {
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }

}
