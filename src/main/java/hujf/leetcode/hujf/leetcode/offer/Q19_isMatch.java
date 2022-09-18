package hujf.leetcode.hujf.leetcode.offer;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q19_isMatch {

    public static void main(String[] args) {
        new Q19_isMatch().isMatch("a", ".*..a");
    }

    /**
     * 动态规划：
     * TODO
     */
    public boolean isMatch2(String s, String p) {
        return false;
    }


    /**
     * 递归法
     */
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int sp, int pp) {
        if (sp == s.length() && pp == p.length()) { //如果子串s和正则p都遍历完了，则匹配
            return true;
        } else if (pp == p.length()) { //如果正则p遍历完了，但是子串s还有字符，则不匹配
            return false;
        }

        if (pp + 1 == p.length() || p.charAt(pp + 1) != '*') { //如果正则p的待匹配的第2位不是*
            if (sp == s.length()) { // 且如果子串s已遍历完，则不匹配
                return false;
            } else if (s.charAt(sp) != p.charAt(pp) && '.' != p.charAt(pp) ) {//且如果子串s的当前位跟正则p的当前位不同，则不匹配
                return false;
            } else {//如果匹配，则需要递归看剩下的子串
                return isMatch(s, p, sp + 1, pp + 1);
            }
        }

        while (sp != s.length() && (s.charAt(sp) == p.charAt(pp) || '.' == p.charAt(pp))) { //如果正则p的待匹配第2位是*，需要遍历所有待匹配的当前位相同的剩余子串，只要有一个子串匹配则匹配
            if (isMatch(s, p, sp, pp + 2)) { //
                return true;
            }
            ++sp;
        }

        //知道s的子串当前位不等于正则p的当前位时，匹配*后剩余的正则
        return isMatch(s, p, sp, pp + 2);


    }

}
