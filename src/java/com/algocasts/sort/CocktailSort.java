package java.com.algocasts.sort;

/**
 * @Description: 鸡尾酒排序是冒泡排序的一种变体，又叫做双向冒泡排序。
 * 顾名思义，它从两个方向对数组或序列进行冒泡排序。
 * 每一次从左向右进行冒泡排序后，紧接着一次从右向左的冒泡排序。
 * 这样从左向右，然后从右向左，来回反复地进行冒泡排序，就像在摇晃调制一杯鸡尾酒，因此得名鸡尾酒排序。
 * @Auther: Archy
 * @Date: 2019/9/7 15:06
 */
public class CocktailSort {

    // Time: O(n^2), Space: O(1)
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0, right = arr.length - 1;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                }
            }
            left++;
        }
    }

    // Time: O(n^2), Space: O(1)
    public void sortEarlyReturn(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        boolean swapped;

        int left = 0, right = arr.length - 1;
        while (left < right) {
            swapped = false;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    swapped = true;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                    swapped = true;
                }
            }
            left++;

            if (!swapped) {
                return;
            }
        }
    }

    // Time: O(n^2), Space: O(1)
    public void sortSkip(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0, right = arr.length - 1;
        int newLeft , newRight;

        while (left < right) {
            newRight = left;
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    newRight = i;
                }
            }
            right = newRight;

            newLeft = right;
            for (int i = right; i > left; i--) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                    newLeft = i;
                }
            }
            left = newLeft;

        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
