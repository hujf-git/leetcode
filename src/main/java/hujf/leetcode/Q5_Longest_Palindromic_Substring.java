package hujf.leetcode;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * 可用于笔试
 */
public class Q5_Longest_Palindromic_Substring {

    public static void main(String[] args) {
        new Q5_Longest_Palindromic_Substring().longestPalindrome3("cbbd");
    }

    /**
     * 动态规划 O2
     * 状态转移方程 dp[i][j] = dp[i+1][j-1] 是回文同时 s[i]==s[j]
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // 初始化dp
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = true;
        }

        int start = 0;
        int end = 0;
        for (int len = 1; len <= s.length(); ++len) {
            for (int i = 0; i < s.length() - len + 1; ++i) {
                int j = i + len - 1;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (i + 1 <= j - 1) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] == true && end - start < j - i) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }



    /**
     * 中心扩散法 优雅版 O2复杂度
     */
    public String longestPalindrome2_2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        //当前最长回文子串的下标
        int start = 0;
        int end = 0;

        //要分别计算中心点为1个和2个点时的回文串
        for (int i = 0; i < s.length(); i++) {
            int[] c1 = expandPalindromic2(s, i, i);
            int[] c2 = expandPalindromic2(s, i, i + 1);
            int[] c = c2[1] - c2[0] + 1 > c1[1] - c1[0] + 1 ? c2 : c1;
            if (c[1] - c[0] + 1 > end - start + 1) {
                start = c[0];
                end = c[1];
            }
        }
        return s.substring(start, end + 1);
    }

    //最长回文串的前后下标
    private int[] expandPalindromic2(String s, int l, int r) {
        while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return new int[] {l + 1, r - 1};
    }

    /**
     * 中心扩散法 O2复杂度
     */
    public String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        String longestPalindromeStr = "";
        for (int i = 1; i < s.length(); ++i) {
            String s1 = expandPalindromic(s, i - 1, i - 1);
            String s2 = expandPalindromic(s, i - 1, i);
            if (s1.length() > longestPalindromeStr.length()) {
                longestPalindromeStr = s1;
            }
            if (s2.length() > longestPalindromeStr.length()) {
                longestPalindromeStr = s2;
            }
        }
        return longestPalindromeStr;
    }

    //如果是以单个数为中心点，则c1=c2，否则双个数则c1=c2-1
    private String expandPalindromic(String s, int c1, int c2) {
        if (s.charAt(c1) != s.charAt(c2)) {
            return "";
        }

        int i = 0;
        while (true) {
            //到了边界，则不再膨胀
            if (c1 - i == 0 || c2 + i == s.length() - 1) {
                break;
            }
            //如果膨胀后不是回文，则不再膨胀
            if (s.charAt(c1 - i - 1) != s.charAt(c2 + i + 1)) {
                break;
            }
            ++i;
        }
        return s.substring(c1 - i, c2 + i + 1);
    }

    /**
     * 暴力解法 O3复杂度
     */
    public String longestPalindrome1(String s) {
        String longestPalindromeStr = "";
        for (int i = 0; i < s.length(); i++) {
            for(int j = s.length(); i < j - longestPalindromeStr.length(); j--) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr)) {
                    longestPalindromeStr = subStr;
                }
            }
        }
        return longestPalindromeStr;
    }

    // 是否回文
    private boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
