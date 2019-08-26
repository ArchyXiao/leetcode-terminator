import java.util.ArrayDeque;

/**
 * @Description:
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 *
 * Example:
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * @Auther: xiaoshude
 * @Date: 2019/8/26 11:10
 */
public class SlidingWindowMaximum {

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] nums;

    /**
     * @Description: 暴力法
     * 最简单直接的方法是遍历每个滑动窗口，找到每个窗口的最大值。
     * 一共有 N - k + 1 个滑动窗口，每个有 k 个元素，于是算法的时间复杂度为 O(Nk)，表现较差。
     *
     * 时间复杂度：O(Nk)。其中 N 为数组中元素个数。
     *
     * 空间复杂度：O(N−k+1)，用于输出数组。
     *
     * @param nums
     * @param k
     * @return: int[]
     */
    public int[] maxSlidingWindow01(int[] nums, int k) {
        int length = nums.length;
        if (length * k == 0) {
            return new int[0];
        }

        int[] output = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * @Description: 双端队列
     * 如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。
     * 在大小为 k 的堆中插入一个元素消耗 log(k) 时间，因此算法的时间复杂度为 O(Nlog(k))。
     *
     * 我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
     * 存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
     *
     * 处理前 k 个元素，初始化双向队列。
     * 遍历整个数组。在每一步 :
     * 1) 清理双向队列 :
     *   - 只保留当前滑动窗口中有的元素的索引
     *   - 移除比当前元素小的所有元素，它们不可能是最大的
     * 2) 将当前元素添加到双向队列中。
     * 3) 将 deque[0] 添加到输出中。
     * 4) 返回输出数组。
     *
     * 时间复杂度：O(N)，每个元素被处理两次，其索引被添加到双向队列中和被双向队列删除。
     *
     * 空间复杂度：O(N)，输出数组使用了 O(N−k+1) 空间，双向队列使用了O(k)。
     *
     * @param nums
     * @param k
     * @return: int[]
     */
    public int[] maxSlidingWindow02(int[] nums, int k) {
        int length = nums.length;

        if (nums == null || k == 0 || k > length) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        // init deque and output
        int maxId = 0;
        this.nums = nums;
        int[] output = new int[length - k + 1];
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            if (nums[i] > nums[maxId]) {
                maxId = i;
            }
        }

        output[0] = nums[maxId];
        // output[i - k + 1] = nums[deque.getFirst()];

        // build output
        for (int i = k; i < length; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }

        return output;
    }

    public void cleanDeque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }

    /**
     * @Description:
     * Deque 的含义是 “double ended queue”，即双端队列，它具有队列和栈的性质的数据结构。
     * 顾名思义，它是一种前端与后端都支持插入和删除操作的队列。
     * Deque 继承自 Queue（队列），它的直接实现有 ArrayDeque、LinkedList 等。
     *
     * 利用一个双端队列，在队列中存储元素在数组中的位置， 并且维持队列的严格递减,，也就说维持队首元素是最大的。
     * 当遍历到一个新元素时, 如果队列里有比当前元素小的，就将其移除队列，以保证队列的递减。
     * 当队列元素位置之差大于 k，就将队首元素移除。
     *
     * @param nums
     * @param k
     * @return: int[]
     */
    public int[] maxSlidingWindow03(int[] nums, int k) {
        int length = nums.length;
        if (nums == null || k > length || k == 0) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] res = new int[length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            //在尾部添加元素，并保证左边元素都比尾部大
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //在头部移除元素
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            //输出结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }






}
