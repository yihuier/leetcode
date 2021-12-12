package from400;

/**
 * @author yihuier
 */
public class Solution495 {
    // 主要在于计算如果有交集，中毒时间应该怎么算
    // 还有一种计算方式是 total += Math.min(timeSeries[i + 1] - timeSeries[i], duration); 这种更加直观一点
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int currentTime = 0;
        int sum = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (currentTime <= timeSeries[i]) {
                sum += duration;
            } else {
                sum += timeSeries[i] + duration - currentTime;
            }
            currentTime = timeSeries[i] + duration;
        }
        return sum;
    }
}
