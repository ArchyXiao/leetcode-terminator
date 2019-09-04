package edu.sword.refers.data_operation;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 旋转数组的最小的数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
 *
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 *
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @Auther: xiaoshude
 * @Date: 2019/9/3 10:35
 */
public class MinNumberInRotateArray {

    /**
     * @Description:
     * 在两段范围内都是非降序，当不符合这个规律时，就找到了最小数字
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param array
     * @return: int
     */
    public int minNumberInRotateArray01(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    /**
     * @Description:
     * 利用 Arrays 工具类里的排序函数，默认的排序规则是从小到大，排序后的数组第一个值就是最小值
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param array
     * @return: int
     */
    public int minNumberInRotateArray02(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    /**
     * @Description:
     * 将数组元素挨着丢进优先队列，优先队列默认为最小堆，弹出的第一个数就是整个数组的最小值
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param array
     * @return: int
     */
    public int minNumberInRotateArray03(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
        }

        return queue.poll();
    }

    /**
     * @Description:
     * 二分查找用于查找有序的数组中的值，题目所给数组在两段范围内有序，我们可以将给定数组分为两种情况：
     * 其实并没有旋转，例如 {1,2,3,4,5}，旋转后也是 {1,2,3,4,5}，这样可以直接使用二分查找
     * 如题所示，旋转了一部分，例如 {1,2,3,4,5}，旋转后为 {3,4,5,1,2}，需要限定特殊条件后使用二分查找
     *
     * 当数组如情况 1，有个鲜明的特征，即数组左边元素 < 数组右边元素，这时我们直接返回首元素即可
     *
     * 当数组如情况 2，此时有三种可能找到最小值：
     * 下标为 n+1 的值小于下标为 n 的值，则下标为 n+1 的值肯定是最小元素
     * 下标为 n 的值小于下标为 n-1 的值，则下标为 n 的值肯定是最小元素
     * 由于不断查找，数组查找范围内的值已经全为非降序（退化为情况1）
     *
     * 再讨论每次二分查找时范围的变化，由于情况数组的情况 1 能直接找到最小值，需要变化范围的肯定是情况 2：
     * 当下标为 n 的值大于下标为 0 的值，从 0 到 n 这一段肯定是升序，由于是情况 2，最小值肯定在后半段
     * 当下标为 n 的值小于下标为 0 的值，从 0 到 n 这一段不是升序，最小值肯定在这一段
     *
     * 考虑重复元素存在的递增序列 {0，1, 1, 1，1}
     * 两个旋转数组 ｛1, 0，1, 1, 1｝ {1, 1, 1, 0, 1}
     *
     * @param array
     * @return: int
     */
    public int minNumberInRotateArray04(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[low] < array[high]) {
                return array[low];
            }
            if (array[mid] > array[low]) {
                low = mid + 1;
            } else  if (array[mid] < array[high]){
                high = mid;
            } else {
                low++;
            }
        }
        return array[low];
    }
}
