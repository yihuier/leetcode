package start600;

/**
 *  @author yihuier
 *  @Date 2020/12/1 17:24
 *  @Description
 */
public class Solution682 {

    public int calPoints(String[] ops) {
        int sum = 0;
        int cur = 0;
        int index = 0;
        int[] eachScore = new int[ops.length];

        for (String s : ops) {
            if ("+".equals(s)) {
                cur = eachScore[index - 1] + eachScore[index - 2];
            } else if ("D".equals(s)) {
                cur = eachScore[index - 1] * 2;
            } else if ("C".equals(s)) {
                cur = -eachScore[index - 1];
                sum += cur;

                index--;
                continue;
            } else {
                cur = Integer.parseInt(s);
            }

            sum += cur;
            eachScore[index] = cur;
            index++;
        }

        return sum;
    }
}
