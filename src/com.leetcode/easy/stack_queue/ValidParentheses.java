package easy.stack_queue;

import java.util.Stack;

/**
 * @Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is
 * valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 * @Auther: Archy
 * @Date: 2019/11/23 20:20
 */
public class ValidParentheses {

    // Time: O(n), Space: O(n)
    public boolean isValid(String s) {
        Stack<Character> stack  = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else {
                if (s.charAt(i) == ')' && stack.peek() != '(') {
                    return false;
                }
                if (s.charAt(i) == ']' && stack.peek() != '[') {
                    return false;
                }
                if (s.charAt(i) == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // Time: O(n), Space: O(n)
    // 扫描字符串过程，遇到左括号先将其对应的右括号入栈
    // 在后续扫描遇到右括号时，可以直接将其与栈顶弹出元素进行对比
    // 而不需要关心遇到的是哪种类型的右括号
    public boolean isValid02(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid(""));
    }
}
