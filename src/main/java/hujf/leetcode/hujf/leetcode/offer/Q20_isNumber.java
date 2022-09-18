package hujf.leetcode.hujf.leetcode.offer;

import java.util.*;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *  
 *
 * 示例 1：
 *
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "    .1  "
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q20_isNumber {

    // 定义状态
    int spaceStart = 0;
    int signForDigital = 1;
    int digitalBeforeDot = 2;
    int dot = 3;
    int digitalAfterDot = 4;
    int exponent = 5;
    int signForExponent = 6;
    int digitalAfterExponent = 7;
    int spaceEnd = 8;

    //定义状态转移
    Map<Character, Integer>[] StateTo = new HashMap<>[9];
    {
        StateTo[spaceStart] = new HashMap<>() {
            {
                put(' ', spaceStart);
                put('s', signForDigital);
                put('d', digitalAfterDot);
                put('.', dot);
                put('')
            }
        };


                new HashSet<>(Arrays.asList(spaceStart, signForDigital, digitalBeforeDot, dot, digitalAfterDot));
        StateTo[signForDigital] = new HashSet<>(Arrays.asList(digitalBeforeDot, dot, digitalAfterDot));
        StateTo[digitalBeforeDot] = new HashSet<>(Arrays.asList(digitalBeforeDot, dot));
        StateTo[dot] = new HashSet<>(Arrays.asList(digitalAfterDot));
        StateTo[digitalAfterDot] = new HashSet<>(Arrays.asList(digitalAfterDot, exponent, spaceEnd));
        StateTo[exponent] = new HashSet<>(Arrays.asList(signForExponent, digitalAfterExponent));
        StateTo[signForExponent] = new HashSet<>(Arrays.asList(digitalAfterExponent));
        StateTo[digitalAfterExponent] = new HashSet<>(Arrays.asList(digitalAfterExponent, spaceEnd));
        StateTo[spaceEnd] = new HashSet<>(Arrays.asList(spaceEnd));

    }


    public boolean isNumber(String s) {
        int cur = spaceStart;
        for (int i = 0; i < s.length(); ++i) {
            int next = -1;
            char c = s.charAt(i);
            if (c == ' ') {
                next = cur == spaceStart ?
            } else if (c == '+' || c == '-') {

            } else if (c >= '0' && c <= '9') {

            } else if (c == '.') {

            } else if (c == 'e' || c == 'E') {

            } else {

            }
        }

    }


}
