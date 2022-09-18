package hujf.leetcode;

/**
 * https://leetcode.cn/problems/palindrome-number/
 */
public class Q9_Palindrome_Number {

    public static void main(String[] args) {
        System.out.println(new Q9_Palindrome_Number().isPalindrome2(11));
    }

    /**
     * 反转数字，判断是否相等（如果反转后溢出，则一定不是回文）
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int t = x;
        while (t > 0) {
            y = y * 10 + t % 10;
            t = t / 10;
        }
        return x == y;
    }



    /**
     * 此方案想到不难，但边界条件太多，不是好方法
     *
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int len = 1;
        while (len <= x / 10 && x % 10 > 0) {
            len *= 10;
        }
        while (x > 0) {
            if (x < 10 && len <= 1) {
                return true;
            }
            if (x > len) {
                int l = x / len;
                int r = x % 10;
                if (l != r) {
                    return false;
                }
                x = x % len / 10;
                len = len / 100;
            } else {
                int r = x % 10;
                if (r != 0) {
                    return false;
                }
                x = x / 10;
                len = len / 100;
            }
        }
        return true;
    }
}
