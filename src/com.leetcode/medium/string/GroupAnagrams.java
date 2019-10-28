package string;

import java.util.*;

/**
 * @Description:
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 *
 * @Auther: Archy
 * @Date: 2019/10/27 01:13
 */
public class GroupAnagrams {

    // Time: O(n*k)
    // Time: O(n*k*log(k)), Space: O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKeyByCount2(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getKeyBySort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    // Time: O(k)
    // 使用一个字节来保存同一字母出现的次数
    // 假若允许无意义单词，且相同字母可以出现任意多次，那么使用该方法得到的 key 值可能会重复
    private String getKeyByCount(String str) {
        char[] chars = new char[26];

        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }

        return new String(chars);
    }

    // Time: O(k)
    private String getKeyByCount2(String str) {
        int[] ints = new int[26];
        for (int i = 0; i < str.length(); i++) {
            ints[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (ints[i] != 0) {
                sb.append((char)('a' + i)).append(ints[i]);
            }
        }

        return sb.toString();
    }
}
