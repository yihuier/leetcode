package start1200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 *  @author yihuier
 *  @Date 2020/11/10 14:01
 *  @Description
 */
public class Solution1021 {

    public String removeOuterParentheses2(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int startIndex = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.append(S, startIndex + 1, i);
                    startIndex = i + 1;
                }
            } else {
                stack.push(S.charAt(i));
            }
        }

        return sb.toString();
    }

    public String removeOuterParentheses(String S) {
        int outerLeftIndex = 0;
        int leftCount = 0;
        int rightCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                sb.append(S, outerLeftIndex + 1, i);
                outerLeftIndex = i + 1;
                leftCount = 0;
                rightCount = 0;
            }
        }

        return sb.toString();
    }
}
