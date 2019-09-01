package edu.sword.refers.base_structure;

/**
 * @Description: 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 合并两个数组（包括字符串）时，如果从前往后复制每个数字（或字 符）需要重复移动数字（或字符）多次，
 * 那么我们可以考虑从后往前复制， 这样就能减少移动的次数，从而提高效率。
 *
 * @Auther: Archy
 * @Date: 2019/8/31 23:34
 */
public class ReplaceBlank {
    public String replaceSpace01(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    public String replaceSpace02(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String replaceSpace03(StringBuffer str) {
        if (str == null) {
            return null;
        }

        int count = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int src = length - 1;
        int target = src + count * 2;
        str.setLength(target + 1);
        while (src >= 0) {
            if (str.charAt(src) == ' ') {
                str.replace(target - 2, target + 1, "%20");
                target -= 3;
            } else {
                str.setCharAt(target, str.charAt(src));
                target--;
            }
            src--;
        }
        return str.toString();
    }
}
