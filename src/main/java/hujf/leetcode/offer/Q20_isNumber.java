package hujf.leetcode.offer;

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

    public static void main(String[] args) {
        new Q20_isNumber().isNumber("3. ");
    }

    // 定义状态
    int spaceStart = 0;
    int signForDigital = 1;
    int digitalBeforeDot = 2;
    int dotWithDigital = 3;
    int digitalAfterDot = 4;
    int exponent = 5;
    int signForExponent = 6;
    int digitalAfterExponent = 7;
    int spaceEnd = 8;
    int dotWithoutDigital = 9;

    //定义状态转移
    Map<Character, Integer>[] stateTo = new HashMap[10];
    {
        stateTo[spaceStart] = new HashMap<>();
        stateTo[spaceStart].put(' ', spaceStart);
        stateTo[spaceStart].put('s', signForDigital);
        stateTo[spaceStart].put('d', digitalBeforeDot);
        stateTo[spaceStart].put('.', dotWithoutDigital);

        stateTo[signForDigital] = new HashMap<>();
        stateTo[signForDigital].put('d', digitalBeforeDot);
        stateTo[signForDigital].put('.', dotWithoutDigital);

        stateTo[digitalBeforeDot] = new HashMap<>();
        stateTo[digitalBeforeDot].put('d', digitalBeforeDot);
        stateTo[digitalBeforeDot].put('.', dotWithDigital);
        stateTo[digitalBeforeDot].put('e', exponent);
        stateTo[digitalBeforeDot].put(' ', spaceEnd);

        //最关键的， '.' 需要分状态讨论是否合法，在数字后的.是合法的，前后没有数字的.是不合法的
        stateTo[dotWithDigital] = new HashMap<>();
        stateTo[dotWithDigital].put('d', digitalAfterDot);
        stateTo[dotWithDigital].put('e', exponent);
        stateTo[dotWithDigital].put(' ', spaceEnd);

        stateTo[digitalAfterDot] = new HashMap<>();
        stateTo[digitalAfterDot].put('d', digitalAfterDot);
        stateTo[digitalAfterDot].put('e', exponent);
        stateTo[digitalAfterDot].put(' ', spaceEnd);

        stateTo[exponent] = new HashMap<>();
        stateTo[exponent].put('s', signForExponent);
        stateTo[exponent].put('d', digitalAfterExponent);

        stateTo[signForExponent] = new HashMap<>();
        stateTo[signForExponent].put('d', digitalAfterExponent);

        stateTo[digitalAfterExponent] = new HashMap<>();
        stateTo[digitalAfterExponent].put('d', digitalAfterExponent);
        stateTo[digitalAfterExponent].put(' ', spaceEnd);

        stateTo[spaceEnd] = new HashMap<>();
        stateTo[spaceEnd].put(' ', spaceEnd);

        stateTo[dotWithoutDigital] = new HashMap<>();
        stateTo[dotWithoutDigital].put('d', digitalAfterDot);

    }

    // 定义合法状态
    Set<Integer> validStatus = new HashSet<>();
    {
        validStatus.addAll(Arrays.asList(digitalBeforeDot, digitalAfterDot, digitalAfterExponent, spaceEnd, dotWithDigital));
    }

    /**
     * 有限自动状态机
     */
    public boolean isNumber(String s) {
        Integer cur = spaceStart;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            //映射当前字符到它所在到状态
            if (c == ' ') {
                cur = stateTo[cur].get(' ');
            } else if (c == '+' || c == '-') {
                cur = stateTo[cur].get('s');
            } else if (c >= '0' && c <= '9') {
                cur = stateTo[cur].get('d');
            } else if (c == '.') {
                cur = stateTo[cur].get('.');
            } else if (c == 'e' || c == 'E') {
                cur = stateTo[cur].get('e');
            } else {
                cur = null;
            }
            if (cur == null) {
                return false;
            }
        }
        return validStatus.contains(cur);
    }

}
