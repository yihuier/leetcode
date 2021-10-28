package from800;

/**
 *  @author yihuier
 *  @Date 2020/12/2 19:38
 *  @Description
 */
public class Solution844 {

    /**
     * LeetCode 上提供的一种巧妙的解法
     * 首先从最后开始遍历，然后通过skipS和skipT来记录应该跳过判断的字符
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    /**
     * 老老实实的求出两个字符串的最终结果，然后比较
     */
    public boolean backspaceCompare2(String S, String T) {
        String result1 = getResult(S);
        String result2 = getResult(T);

        return result1.equals(result2);
    }

    private String getResult(String str) {
        StringBuilder sb = new StringBuilder();

        for (Character ch : str.toCharArray()) {
            if (ch == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
