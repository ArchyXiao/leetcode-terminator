package com.leetcode.medium.string;

import java.util.*;

/**
 * @Description:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @Auther: xiaoshude
 * @Date: 2019/8/27 13:05
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @Description: 逐个检查所有的子字符串，看它是否不含有重复的字符
     * 假设我们有一个函数 boolean allUnique(String substring) ，如果子字符串中的字符都是唯一的，它会返回 true，否则会返回 false。
     * 我们可以遍历给定字符串 s 的所有可能的子字符串并调用函数 allUnique。
     * 如果事实证明返回值为 true，那么我们将会更新无重复字符子串的最大长度的答案。
     *
     * 现在让我们填补缺少的部分：
     * 为了枚举给定字符串的所有子字符串，我们需要枚举它们开始和结束的索引。
     * 假设开始和结束的索引分别为 i 和 j。因此，使用 i 从 0 到 n−1 以及 j 从 i + 1 到 n 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。
     *
     * 要检查一个字符串是否有重复字符，我们可以使用集合。
     * 我们遍历字符串中的所有字符，并将它们逐个放入 set 中。
     * 在放置一个字符之前，我们检查该集合是否已经包含它。
     * 如果包含，我们会返回 false。循环结束后，我们返回 true。
     *
     * 时间复杂度：O(n^3)
     * 要验证索引范围在 [i, j)[i,j) 内的字符是否都是唯一的，我们需要检查该范围中的所有字符。 因此，它将花费 O(j - i)O(j−i) 的时间。
     * 对于给定的 i，对于所有 [i+1, n]j∈[i+1,n] 所耗费的时间总和为：
     *
     * 因此，执行所有步骤耗去的时间总和为：O(n^3)
     * 空间复杂度：O(min(n, m))，我们需要 O(k) 的空间来检查子字符串中是否有重复字符，其中 k 表示 Set 的大小。
     * 而 Set 的大小取决于字符串 n 的大小以及字符集/字母 m 的大小。
     *
     * @param s
     * @return: int
     */
    public int lengthOfLongestSubstring01(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }

            set.add(ch);
        }
        return true;
    }

    /**
     * @Description:
     * 在暴力法中，我们会反复检查一个子字符串是否含有重复的字符，但这是没有必要的。如果从索引 i 到 j - 1之间的子字符串 s[i, j)
     *  已经被检查为没有重复字符。我们只需要检查 s[j] 对应的字符是否已经存在于子字符串
     * 要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n^2)O(n) 的算法，但我们可以做得更好。
     *
     * 通过使用 HashSet 作为滑动窗口，我们可以用 O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
     * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j) 向右滑动 1 个元素，则它将变为 [i+1, j+1)（左闭，右开）。
     *
     * 回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中。
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
     * 直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头。
     *
     * 时间复杂度：O(2n) = O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
     * 空间复杂度：O(min(m, n))，与之前的方法相同。滑动窗口法需要 O(k) 的空间，其中 k 表示 Set 的大小。而 Set 的大小取决于字符串 n 的大小以及字符集 / 字母 m 的大小。
     *
     * @param s
     * @return: int
     */
    public int lengthOfLongestSubstring02(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * @Description:
     * 上述的方法最多需要执行 2n 个步骤。
     * 事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。
     * 当我们找到重复的字符时，我们可以立即跳过该窗口。
     * 也就是说，如果 s[j]在 [i, j) 范围内有与 j' 重复的字符，我们不需要逐渐增加 i 。
     * 我们可以直接跳过 [i，j'] 范围内的所有元素，并将 i 变为 j' + 1
     *
     * 时间复杂度：O(n)，索引 j 将会迭代 n 次。
     * 空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
     * 空间复杂度（Table）：O(m)，m 是字符集的大小。
     *
     * @param s
     * @return: int
     */
    public int lengthOfLongestSubstring03(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * @Description:
     * Java（假设字符集为 ASCII 128）
     * 以前的我们都没有对字符串 s 所使用的字符集进行假设。
     * 当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
     *
     * 常用的表如下所示：
     * int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
     * int [128] 用于ASCII码
     * int [256] 用于扩展ASCII码
     *
     * @param s
     * @return: int
     */
    public int lengthOfLongestSubstring04(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[256];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, index[s.charAt(j)]);
            ans = Math.max(ans, j -i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    // Time: O(n), Space: O(m), m 是字符集大小
    // 双指针法，从下标零开始，遍历字符串 2次
    // 计数数组中存在该字符，则跳出内层循环
    // 不存在则进行计数，并且持续移动 j 游标
    // 外层循环取内外层循坏的游标差值 j - i, 并且与 maxLen 作比较
    // 外层循环游标移动时必须减掉当前游标 i 在 count 数组中的计数
    public int lengthOfLongestSubstring05(String s) {
        int[] counts = new int[256];
        int i = 0, j = 0, maxLen = 0;
        for (; i < s.length(); i++) {
            for (; j < s.length(); j++) {
                if (counts[s.charAt(j)] != 0) {
                    break;
                }
                counts[s.charAt(j)] += 1;
            }
            maxLen = Math.max(maxLen, j - i);
            counts[s.charAt(i)] -= 1;
        }
        return maxLen;
    }

    // Time: O(n), Space: O(m), m 是字符集大小
    // 对方法05的改良
    // 当游标 j 遇到重复字符时，游标 i 可以直接跳到 j 的下一个位置
    // 因为中间就算存在不重复子串，长度也不可能超过 maxLen
    // index 数组用于记录字符在字符串中的下标，下标为 0 时同样有意义，所以必须全部初始化为 -1
    public int lengthOfLongestSubstring06(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            i = Math.max(i, index[s.charAt(j)] + 1);
            maxLen = Math.max(maxLen, j - i + 1);
            index[s.charAt(j)] = j;
        }
        return maxLen;
    }
}
