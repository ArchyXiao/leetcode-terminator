package easy.array;

/**
 * @Description:
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the
 * array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 * @Auther: Archy
 * @Date: 2020/12/13 13:45
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int size = digits.length;
        for (int i = size-1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            if (sum % 10 != 0) {
                return digits;
            }
        }

        int[] newDigits = new int[size+1];
        newDigits[0] = 1;
        for (int i = 0; i < size; i++) {
            newDigits[i+1] = digits[i];
        }

        return newDigits;
    }
}
