package com.algocasts.sort;

/**
 * @Description:
 * 冒泡排序的原理是，每一次遍历数组，都去不断地比较相邻的两个元素，如果它们的顺序不对，就交换这两个元素，比如把较大的换到后面。
 * 第一次遍历可以把最大的元素确定下来，放在最后的位置。第二次遍历可以确定第二大的元素，依次类推。
 * 这样遍历 N 次后，整个数组就变成递增有序。
 *
 * T: O(n^2)
 * S: O(1)
 *
 * @Auther: Archy
 * @Date: 2019/9/7 14:25
 */
public class BubbleSort {

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        for (int end = n - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    /**
     * @Description: 利用一个标志位，记录上一轮排序是否存在交换元素操作；若无，则提前返回
     * @param array
     * @return: void
     */
    public void bubbleSortEarlyReturn(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        boolean swapped = false;
        for (int end = n - 1; end > 0; end--) {
            swapped = false;
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        }
        if (!swapped) {
            return;
        }
    }

    /**
     * @Description: 保存上一轮最后交换元素的位置，将此位置作为下一轮循环的终点
     * @param array
     * @return: void
     */
    public void bubbleSortSkip(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        int newEnd;
        for (int end = n - 1; end > 0; end--) {
            newEnd = 0;
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    newEnd = i;
                }
            }
            end = newEnd;
        }

    }
}
