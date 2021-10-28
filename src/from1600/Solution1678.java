package from1600;

/**
 *  @author yihuier
 *  @Date 2020/12/16 10:40
 *  @Description
 */
public class Solution1678 {

    /**
     * 因为字符串的格式固定了，所以直接根据字符判断处理
     */
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < command.length()) {
            char c = command.charAt(i);
            if (c == 'G') {
                sb.append('G');
                i++;
            } else if (c == '(' && i < command.length() - 1 && command.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
            } else {
                sb.append("al");
                i += 4;
            }
        }

        return sb.toString();
    }
}
