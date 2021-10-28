package from500;

/**
 *  @author yihuier
 *  @Date 2020/4/15 21:02
 *  @Description
 */
public class Solution521 {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }
}
