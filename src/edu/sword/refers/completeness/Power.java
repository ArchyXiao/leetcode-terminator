package edu.sword.refers.completeness;

/**
 * @Description: 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * 全面考虑边界情况
 * 1、 base为0，exponent < 0，无效的输入
 * 2、指数为正
 * 3、指数为负
 * 4、指数为0四种情况即可
 *
 * @Auther: xiaoshude
 * @Date: 2019/9/6 14:56
 */
public class Power {
    /**
     * @Description:
     * 没考虑负数输入值
     *
     * @param base
     * @param exponent
     * @return: double
     */
    public double power01(double base, int exponent) {
        double res = 1.0;
        for (int i = 1; i <= exponent; i++) {
            res *= base;
        }
        return res;
    }


    /**
     * @Description:
     * 加入对输入值为负数的判断
     * 注意：
     * 判断底数 base 是否等于 0 时，不能直接写 base == 0
     * 因为在计算机内表示小数时都有误差
     * 判断两个小数是否相等，只能判断它们之差的绝对值是不是在一个很小的范围内
     * 若两个数相差很小，就可以认为它们相等
     *
     * @param base
     * @param exponent
     * @return: double
     */
    public double power02(double base, int exponent) {
        if ((Math.abs(base) < 0.00001) && exponent < 0) {
            throw  new RuntimeException("负数指数的底数不能为 0");
        }
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            double res = 1.0;
            for (int i = 1; i <= exponent; i++) {
                res *= base;
            }
            return res;
        } else {
            double num = 1.0;
            for (int i = 1; i <= -exponent; i++) {
                num *= base;
            }
            return 1 / num;
        }
    }

    /**
     * @Description:
     * @param base
     * @param exponent
     * @return: double
     */
    public double power03(double base, int exponent) {
        double res = 1.0;
        int tmpExponent;
        if (exponent > 0) {
            if (exponent == 1) {
                return base;
            }
            tmpExponent = exponent;
        } else if (exponent < 0) {
            if (Math.abs(base) < 0.0000001) {
                throw new RuntimeException("负数指数的底数不能为 0");
            }
            tmpExponent = -exponent;
        } else {
            return 1;
        }

        double curr = base;
        while (tmpExponent != 0) {
            // 判断是否为奇数
            if ((tmpExponent & 1) == 1) { // 可以替换为 tmp % 2 != 0
                res *= curr;
            }
            curr *= curr;
            tmpExponent >>= 1;
        }
        return exponent > 0 ? res : 1 / res;
    }

























}
