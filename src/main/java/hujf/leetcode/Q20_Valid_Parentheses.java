package hujf.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class Q20_Valid_Parentheses {

    public static void main(String[] args) {
        System.out.println(new Q20_Valid_Parentheses().isValid("()"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek().equals(map.get(c))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
