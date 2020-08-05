package array;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/6/2 21:59
 */
public class SortColors {

    // Time: O(n), Space: O(1)
    public void sortThreeColorsCount(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int num: nums) {
            if (num == 0) {
                ++cnt0;
            } else if (num == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        int j = 0;
        for (int i = 0; i < cnt0; ++i) {
            nums[j++] = 0;
        }
        for (int i = 0; i < cnt1; ++i) {
            nums[j++] = 1;
        }
        for (int i = 0; i < cnt2; ++i) {
            nums[j++] = 2;
        }
    }

    // Time: O(n), Space: O(1)
    public void sortThreeColorsSwap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++);
            } else if (nums[mid] == 1) {
                ++mid;
            } else {
                swap(nums, mid, right--);
            }
        }
    }

    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;


    }


}

