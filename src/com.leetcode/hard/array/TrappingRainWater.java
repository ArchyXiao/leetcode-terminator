package array;

/**
 * @Description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 *
 *
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * @Auther: Archy
 * @Date: 2019/10/14 01:09
 */
public class TrappingRainWater {
    // Time: O(n), Space: O(n)
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] d = new int[height.length];
        int leftMax = -1, rightMax = -1, capacity = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax  = Math.max(leftMax, height[i]);
            d[i] = leftMax;
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            capacity += Math.min(rightMax, d[i]) - height[i];
        }

        return capacity;
    }

    // Time: O(n), Space: O(1)
    public int trap02(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int capacity = 0, leftMax = -1, rightMax = -1;
        int i = 0, j = height.length - 1;
        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                capacity += leftMax - height[i++];
            } else{
                capacity += rightMax - height[j--];
            }
        }
        return capacity;
    }
}
