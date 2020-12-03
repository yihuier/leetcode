package start900;

import java.util.Stack;

/**
 *  @author yihuier
 *  @Date 2020/12/3 17:25
 *  @Description
 */
public class Solution921 {

    /**
     * 效率高一点，但是不好理解
     */
    public int minAddToMakeValid(String S) {
        int start = 0;
        int end = S.length() - 1;
        int count = 0;


        while (start <= end) {
            while (start < S.length() && S.charAt(start) != '(') {
                count++;
                start++;
            }

            while (end >= 0 && S.charAt(end) != ')') {
                count++;
                end--;
            }

            int leftCount = 0;
            int rightCount = 0;

            while (start <= end) {
                if (S.charAt(start) == '(' && leftCount <= rightCount && leftCount != 0) {
                    break;
                }
                if (S.charAt(start) == '(') {
                    leftCount++;
                } else {
                    rightCount++;
                }
                start++;
            }

            count += Math.abs(leftCount - rightCount);

        }

        return count;
    }

    /**
     * 遇到括号匹配的问题，使用栈是一个比较直接简单的做法
     */
    public int minAddToMakeValid2(String S) {
        Stack<Character> stack = new Stack<>();

        for (Character c : S.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }
}
