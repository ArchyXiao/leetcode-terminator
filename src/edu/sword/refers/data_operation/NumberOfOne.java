package edu.sword.refers.data_operation;

/**
 * @Description: 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @Auther: xiaoshude
 * @Date: 2019/9/6 12:59
 */
public class NumberOfOne {

    /**
     * @Description:
     * 采用右移运算，让输入值一直和 1 做与运算，从而确定 1 的位数
     * 右移运算在遇到有符号数值时，会在左边填充相应位数的符号标志位，
     * 即输入值若为负数，则会陷入死循环
     *
     * @param n
     * @return: int
     */
    public int numberOfOne01(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1; // n /= 2
        }
        return count;
    }

    /**
     * @Description:
     * 采用标志位左移来累计位数为 1 的情况
     * 避免死循环出现
     *
     * @param n
     * @return: int
     */
    public int numberOfOne02(int n) {
        int count = 0;
        int flag = 1;
        while (n != 0) {
            if ((n & flag) == 1) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * @Description:
     * 前两种方法需要执行的次数等于 【输入值用二进制表示的位数】
     * n & (n - 1) 每次运算会将最靠右出现的 1 置为 0
     * 可以将时间复杂度降为 【二进制中 1 出现的次数】
     *
     * @param n
     * @return: int
     */
    public int numberOfOne03(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }















}
