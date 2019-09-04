package edu.sword.refers.data_operation;

/**
 * @Description:  斐波那契数列
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 *
 * @Auther: xiaoshude
 * @Date: 2019/9/4 11:50
 */
public class Fibonacci {

    /**
     * @Description: 递归法
     * 斐波那契数列的标准公式为：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
     *
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return: int
     */
    public int fibonacci01(int n) {
        if (n <= 1) {
            return 0;
        }
        return fibonacci01(n - 1) + fibonacci01(n - 2);
    }

    /**
     * @Description: 利用数组存储重复元素
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param n
     * @return: int
     */
    public int fibonacci02(int n) {
        if (n <= 1) {
            return n;
        }
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    /**
     * @Description: 进一步优化存储空间
     * 每次就用到了最近的两个数，所以我们可以只存储最近的两个数
     * sum 存储第 n 项的值
     * minusOne 存储第 n-1 项的值
     * minusTwo 存储第 n-2 项的值
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n
     * @return: int
     */
    public int fibonacci03(int n) {
        if (n <= 1) {
            return n;
        }
        int sum = 0;
        int minusOne = 1;
        int minusTwo = 0;
        for (int i = 2; i <= n; i++) {
            sum = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = sum;
        }
        return sum;
    }

    /**
     * @Description: 持续优化
     * sum 只在每次计算第 n 项的时候用一下，其实还可以利用 sum 存储第 n-1 项，例如当计算完 f(n) 时 sum 存储的是 f(n) 的值，
     * 当需要计算 f(n + 1) 时，f(n + 1) = f(n) + f(n - 1)，sum 存储的 f(n)，f(n - 1) 存储在 one 中，由 f(n) - f(n - 2) 得到
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @return: int
     */
    public int fibonacci04(int n) {
        if (n <= 1) {
            return n;
        }
        int sum = 1;
        int one = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }
}
