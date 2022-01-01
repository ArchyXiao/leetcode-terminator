import java.util.Arrays;

/**
 * @Description:
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * 异位词： 包含相同字母，且相同字母出现个数相等
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * 使用哈希表而不是固定大小的计数器。想象一下，分配一个大的数组来适应整个 Unicode 字符范围，这个范围可能超过 100万。
 * 哈希表是一种更通用的解决方案，可以适应任何字符范围。
 *
 * @Auther: Archy
 * @Date: 2019/8/24 14:10
 */
public class ValidAnagram {
    /**
     * @Description: 排序
     * 通过将 ss 的字母重新排列成 tt 来生成变位词。因此，如果 TT 是 SS 的变位词，对两个字符串进行排序将产生两个相同的字符串。
     * 此外，如果 ss 和 tt 的长度不同，tt 不能是 ss 的变位词，我们可以提前返回。
     *
     * 时间复杂度：O(nlogn)，假设 nn 是 ss 的长度，排序成本O(nlogn) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为 O(nlogn)。
     * 空间复杂度：O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1)O(1) 辅助空间。
     * 注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n) 额外的空间。
     * 但是我们忽略了这一复杂性分析，因为这依赖于语言的细节。
     * 取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
     *
     * @param s
     * @param t
     * @return: boolean
     **/
    public boolean isAnagram01(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    /**
     * @Description: 哈希表法
     * 为了检查 t 是否是 s 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 S 和 T 都只包含 A-Z的字母，所以一个简单的 26 位计数器表就足够了。
     * 我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 s 字母的频率，用 t 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
     *
     * @param s
     * @param t
     * @return: boolean
     **/
    public boolean isAnagram02(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
           counter[s.charAt(i) - 'a']++;
           counter[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * @Description:
     * 我们可以先用计数器表计算 s，然后用 t 减少计数器表中的每个字母的计数器。
     * 如果在任何时候计数器低于零，我们知道 t 包含一个不在 s 中的额外字母，并立即返回 FALSE。
     * @param s
     * @param t
     * @return: boolean
     **/
    public boolean isAnagram03(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }






























}
