package hujf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class Q3_Longest_Substring_Without_Repeating_Characters {

    /**
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     * 解法1：使用hashSet后，两层循环，暴力破解
     */
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        for (int start = 0; start < s.length(); start++) {
            Set<Character> set = new HashSet<>();
            for (int end = start; end < s.length(); end++) {
                if (!set.contains(s.charAt(end))) {
                    set.add(s.charAt(end));
                } else {
                    break;
                }
            }
            if (set.size() > ret) {
                ret = set.size();
            }
        }
        return ret;
    }

    /**
     * 解法2：使用hashSet后，两层循环，暴力破解
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int ret = 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            Integer index = map.get(s.charAt(end));
            if (index == null) {
                map.put(s.charAt(end), end);
                end++;
            } else {
                start = index + 1;
                end = start;
                map.clear();;
            }
            if (map.size() > ret) {
                ret = map.size();
            }
        }

        return ret;
    }


}
