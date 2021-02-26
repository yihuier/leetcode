package start800;

/**
 *  @author yihuier
 *  @Date 2020/12/22 10:12
 *  @Description
 */
public class Solution856 {

    public int scoreOfParentheses(String S) {
        int score = 0;
        int tempSum = 0;
        int leftNum = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                leftNum++;
            } else {
                // 这里不对啊

                leftNum--;

                if (leftNum == 0) {
                    score += tempSum;
                    tempSum = 0;
                }
            }
        }

        return score;
    }
}
