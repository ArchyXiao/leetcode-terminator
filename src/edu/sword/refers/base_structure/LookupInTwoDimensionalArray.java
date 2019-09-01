package edu.sword.refers.base_structure;

/**
 * @Description: 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Auther: Archy
 * @Date: 2019/8/31 22:00
 */
public class LookupInTwoDimensionalArray {
    /**
     * @Description: 暴力法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return: boolean
     **/
    public boolean find01(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Description:
     * 和从左下找道理一样，都是因为每次判断都能剔除一整行或一整列
     *
     * 时间复杂度：O(M + N) (行高与列宽之和)
     * 空间复杂度：O(1)
     *
     * @param target
     * @param array
     * @return: boolean
     **/
    public boolean find02(int target, int [][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        int row = 0;
        int col = cols - 1;
        while (col >= 0 && row < rows) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target){
                row++;
            }
        }
        return false;
    }

    /**
     * @Description:
     * 利用该二维数组的性质：
     * 每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序
     * 改变个说法，即对于左下角的值 m，m 是该行最小的数，是该列最大的数
     *
     * 每次将 m 和目标值 target 比较：
     * 当 m < target，由于 m 已经是该行最大的元素，想要更大只有从列考虑，取值右移一位
     * 当 m > target，由于 m 已经是该列最小的元素，想要更小只有从行考虑，取值上移一位
     * 当 m = target，找到该值，返回 true
     * 用某行最小或某列最大与 target 比较，每次可剔除一整行或一整列
     *
     * 时间复杂度：O(M + N) (行高与列宽之和)
     * 空间复杂度：O(1)
     *
     * @param target
     * @param array
     * @return: boolean
     **/
    public boolean find03(int target, int [][] array) {
        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        int row = rows - 1;
        int col = 0;
        while (col < cols && row > 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                row--;
            } else if (array[row][col] < target){
                col++;
            }
        }
        return false;
    }
}
