import java.util.Stack;

/**
 * @Description:
 * Given a list of daily temperatures T,
 * return a list such that,
 * for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures
 * T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 * @Auther: Archy
 * @Date: 2019/8/25 23:28
 */
public class DailyTemperatures {

    /**
     * @Description:
     * 第一种方法，从左到右遍历，这是最容易想到的办法。
     * 其原理是从左到右除了最后一个数其他所有的数都遍历一次，最后一个数据对应的结果肯定是 0，就不需要计算。
     * 遍历的时候，每个数都去向后数，直到找到比它大的数，这其他数了几次就是对应的值。
     *
     * @param T
     * @return: int[]
     **/
    public int[] dailyTemperatures01(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int src = T[i];
            for (int j = i + 1; j < length; j++) {
                if (T[j] > src) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @Description:
     * 第二种方法，怎样减少遍历次数呢？
     * 我们可以分析，遍历一次数组中所有的值应该是少不了的，因为至少数组中每个值都需要计算一遍，所以时间复杂度肯定大于 O(n)。
     *
     * 关键是要减少为每个数寻找值遍历次数。如果我们先从计算右边，那么我们计算过的位置就不需要重复计算
     *
     * @param T
     * @return: int[]
     **/
    public int[] dailyTemperatures02(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            int src = T[i];
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j += result[j]) {
                if (T[j] > src) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * @Description:
     * 本题使用逆序遍历，为什么要使用逆序遍历。因为正常遍历思路，遍历到当前天，你无法知道后面几天的温度情况。
     * 逆序遍历，后面几天的温度情况已经知晓，很容易得到经过几天后的温度比今天温度高。
     *
     * 以某个元素为出发点，第一想法是将后续所有元素入栈，再遍历栈顶与当前元素比较。
     * 遍历过程中我们要找的是首个更大值的下标，某个大值后的较小值对我们毫无意义，剔除降序片段，所以我们的目标是 维护一个从栈顶至栈底递增的栈 。
     * 根据栈后进先出的特性，要从后往前遍历数组。目的是获取下标差值，所以栈保存下标而不是值。
     *
     * 如果当前元素大于等于栈顶元素，则重复pop，直到栈顶元素大于当前元素，二者下标差值即为所求。
     * 如果栈为空，说明栈中没有大于当前元素的值，保存0。
     * 将当前元素（新的最小值）入栈。
     *
     * @param T
     * @return: int[]
     **/
    public int[] dailyTemperatures03(int[] T) {
       int[] res = new int[T.length];

       // 单调栈 里面的数 非递增排序
       Stack<Integer> stack = new Stack<>();

       // 从后往前遍历
       for (int i = T.length - 1; i >= 0; i--) {
            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }

            // 栈为空 即后面没有比当前天温度高的
            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // 当前元素进栈
            stack.push(i);
       }
       return res;
    }



















}
