package start1400;

/**
 *  @author yihuier
 *  @Date 2020/12/15 11:13
 *  @Description
 */
public class Solution1480 {

    /**
     * 数组元素累加前面元素的和
     */
    public int[] runningSum(int[] nums) {
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            nums[i] += curSum;
            curSum += tmp;
        }

        return nums;
    }
}
