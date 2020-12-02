package start1500;

import java.util.Stack;

/**
 *  @author yihuier
 *  @Date 2020/12/2 17:58
 *  @Description
 */
public class Solution1598 {

    /**
     * 借助stack实现
     */
    public int minOperations2(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String log : logs) {
            if ("../".equals(log)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if ("./".equals(log)) {
                // ignore
            } else {
                stack.push(log);
            }
        }

        return stack.size();
    }

    /**
     * 相比于借助于stack，直接记录数值，但是其实在现实场景这种做法没有用处，因为我们不能可真的只要
     * 记录回到根目录的最小回退次数，我们可能还需要一些其他的操作，所以还是借助stack更贴近实际一点
     */
    public int minOperations(String[] logs) {
        int count = 0;

        for (String log : logs) {
            if ("../".equals(log)) {
                if (count != 0) {
                    count--;
                }
            } else if ("./".equals(log)) {
                // ignore
            } else {
                count++;
            }
        }

        return count;
    }
}
