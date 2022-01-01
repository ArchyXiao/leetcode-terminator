package easy.hashtable;

import java.util.Arrays;

/**
 * @Description:
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 * @Auther: Archy
 * @Date: 2019/11/29 21:29
 */
public class FirstUniqueCharacterInString {

    // Time: O(n), Space: O(m)
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // Time: O(n), Space: O(m)
    //  只需遍历一次字符串，当字符串长度足够大时，解法二较有优势
    public int firstUniqChar02(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] count  = new int[26];
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int  i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            count[idx]++;
            if (pos[idx] == -1) {
                pos[idx] = i;
            }
        }

        int firstPos = Integer.MAX_VALUE;
        for (int  i = 0; i < 26; i++) {
            if (count[i] == 1) {
                firstPos = Math.min(firstPos, pos[i]);
            }
        }
        return firstPos == Integer.MAX_VALUE ? -1 : firstPos;
    }
}
