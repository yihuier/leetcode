package from700;

/**
 *  @author yihuier
 *  @Date 2020/12/3 18:20
 *  @Description
 */
public class Solution739 {

    /**
     * 只会这种做法...好菜啊
     */
    public int[] dailyTemperatures(int[] T) {
        int[] waitingDays = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            int j = i + 1;
            int days = 1;
            for (; j < T.length && T[i] >= T[j]; j++) {
                days++;
            }

            if (i == T.length - 1 || j >= T.length) {
                days = 0;
            }
            waitingDays[i] = days;
        }

        return waitingDays;
    }
}
