package hujf.leetcode.offer;

import hujf.leetcode.annotation.Highlight;
import hujf.leetcode.annotation.WithAnswer;
import hujf.leetcode.util.Printer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 */
@WithAnswer
@Highlight
public class Q38_permutation {

    public static void main(String[] args) {
        Printer.sout(new Q38_permutation().permutation("abcd"));
    }

    /**
     * DFS + 剪枝
     */
    public String[] permutation(String s) {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return new String[0];
        }

        List<String> ret = new ArrayList<>();
        char[] cs = s.toCharArray();
        dfs(ret, cs, 0);
        return ret.toArray(new String[ret.size()]);
    }

    private void dfs(List<String> ret, char[] cs, int s) {
        if (s == cs.length) {
            ret.add(String.valueOf(cs));
        }
        Set<Character> cSet = new HashSet<>();
        for (int i = s; i < cs.length; ++i) {
            if (cSet.contains(cs[i])) {
                continue;
            }
            cSet.add(cs[i]);
            swap(cs, s, i);
            dfs(ret, cs, s + 1);
            swap(cs, i, s);
        }
    }

    private void swap(char[] cs, int i, int j) {
        char c = cs[i];
        cs[i] = cs[j];
        cs[j] = c;
    }


}
