package from600;

/**
 * @author yihuier
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        double maxArraySum = -Double.MAX_VALUE;
        double subArraySum = 0;
        int i = 0;
        while (i < k) {
            subArraySum += nums[i];
            i++;
        }
        maxArraySum = Math.max(subArraySum, maxArraySum);
        while (i < nums.length) {
            subArraySum += nums[i] - nums[i - k];
            maxArraySum = Math.max(subArraySum, maxArraySum);
            i++;
        }
        return maxArraySum / k;
    }
}
