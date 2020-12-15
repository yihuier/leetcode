package start1600;

/**
 *  @author yihuier
 *  @Date 2020/12/15 11:09
 *  @Description
 */
public class Solution1672 {

    /**
     * 简单的二维数组求和
     */
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] account : accounts) {
            int wealth = 0;
            for (int i : account) {
                wealth += i;
            }

            max = Math.max(max, wealth);
        }

        return max;
    }
}
