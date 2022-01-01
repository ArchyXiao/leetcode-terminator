package edu.sword.refers.data_operation;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2019/9/4 23:07
 */
public class JumpFloorII {

    /**
     * @Description:
     * 本质上是斐波那契数列的变种，普通跳台阶是一步与两步，问题规模缩小到分成最后要跳到第 n 阶可以跳两次或者一次去求解，
     * 所以，在普通跳台阶，设置两个临时变量存下跳一次或者两次时，前面会有多少种可能的结果
     *
     * 这里用同一个套路来分析一下
     * 若楼梯阶级 n = 3
     * 跳 3 步到 3：没有剩下步数没跳的，只有这样一种跳法
     * 跳 2 步到 3：剩下的是第一步没跳，起始跳到第一步只有一种
     * 跳 1 步到 3：剩下的是第二步没跳，起始跳到第二步有两种
     * 求得，n = 3 时，有 4 种跳法
     *
     * 若楼梯阶级 n = 4
     * 跳 4 步到 4：没有剩下步数没跳的，只有这样一种跳法
     * 跳 3 步到 4：剩下的是第一步没跳，起始跳到第一步只有一种
     * 跳 2 步到 4：剩下的是第二步没跳，起始跳到第二步只有两种
     * 跳 1 步到 4：剩下的是第三步没跳，起始跳到第三步有四种
     * 求得，n = 4 时，有 8 种跳法
     *
     * 若楼梯阶级 n = n
     * 跳 x 步到 n 有几种的和
     * 那么，设置一个数组即可，在求的过程中把值都暂时放在数组里，最后求的时候遍历数据这些求好的对应的阶级种数之和即为新的下级阶梯种数
     *
     * @param target
     * @return: int
     */
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 0; i <= target ; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] += dp[j];
            }
            dp[i]++;
        }
        return dp[target];
    }
}
