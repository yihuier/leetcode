package from1500;

import java.util.Stack;

/**
 *  @author yihuier
 *  @Date 2020/12/2 19:19
 *  @Description 和1047一个道理
 */
public class Solution1544 {

    public String makeGood(String s) {
        if (s.length() <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            if (sb.length() != 0 && ch != sb.charAt(sb.length() - 1)
                    && Character.toLowerCase(ch) == Character.toLowerCase(sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public String makeGood2(String s) {
        if (s.length() <= 1) {
            return s;
        }

        Stack<Character>  stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            if (!stack.isEmpty() && ch != stack.peek()
                    && Character.toLowerCase(ch) == Character.toLowerCase(stack.peek())) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
