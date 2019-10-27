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

    private String getKeyBySort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    public List<List<String>> getGroup(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKeyBySort(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }





















}
