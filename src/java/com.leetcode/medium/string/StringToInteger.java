package com.leetcode.medium.string;

/**
 * @Description:
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have
 * no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN
 * (−231) is returned.
 *
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 *
 * @Auther: xiaoshude
 * @Date: 2019/10/29 10:01
 */
public class StringToInteger {

    // 1. 定义 start，end 游标，以及正负标志位 negative
    // 2. 跳过字符串先导字符(空格)
    // 3. 记录正负号，为后面转整数做准备
    // 4. 找到第一个非零整数开始转化（跳过零值）
    // 5. start = end 确定整数转化起点，end 游标继续往后遍历 0 - 9 范围内字符
    // 6. 若区间大于 10，直接根据正负值返回整型的最大最小值
    // 7. 转化 start，end 区间内字符
    // 8. 根据得到整数是否在区间内，返回对应的值
    public int myAtoi(String str) {
        int start = 0, end = 0, n = str.length();
        boolean negative = false;
        while (end < n && str.charAt(end) == ' ') {
            end++;
        }
        if (end == n) {
            return 0;
        }

        if (str.charAt(end) == '-') {
            negative = true;
            end++;
        } else if (str.charAt(end) == '+'){
            end++;
        }

        while (end < n && str.charAt(end) == '0') {
            end++;
        }
        start = end;

        while (end < n && str.charAt(end) >= '0' && str.charAt(end) <= '9') {
            end++;
        }
        if (start == end) {
            return 0;
        }

        if ((end - start) > 10) {
            if (negative) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }

        }

        long num = 0;
        for (int i = start; i < end; i++) {
            num = num * 10 + (str.charAt(i) - '0');
        }
        num = negative ? -num : num;

        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) num;
        }
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        stringToInteger.myAtoi("4193 with words");
    }
}
