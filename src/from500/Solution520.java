package from500;

/**
 *  @author yihuier
 *  @Date 2020/4/14 21:01
 *  @Description 取三个状态标志，根据情况改变状态标志的值，
 *  最后根据状态标志，返回true和false
 */
public class Solution520 {

    public boolean detectCapitalUse(String word) {
        boolean firstUpper = true;
        boolean allUpper = true;
        boolean allLower = true;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c >= 'a' && c <= 'z') {
                allUpper = false;

                if (i == 0) {
                    firstUpper = false;
                }
            }

            if (c >= 'A' && c <= 'Z') {
                allLower = false;

                if (i != 0) {
                    firstUpper = false;
                }
            }
        }

        return firstUpper || allUpper || allLower;
    }
}
