package start1000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  @author yihuier
 *  @Date 2020/11/29 17:28
 *  @Description
 */
public class Solution1047 {

    public String removeDuplicates(String S) {
        if (S.length() <= 1) {
            return S;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == ch) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public String removeDuplicates2(String S) {
        if (S.length() <= 1) {
            return S;
        }

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : S.toCharArray()) {
            if (deque.isEmpty()) {
                deque.addLast(ch);
                continue;
            }

            if (ch == deque.getLast()) {
                deque.removeLast();
            } else {
                deque.addLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }
}
