package from1900;

import java.util.Arrays;

/**
 * @author yihuier
 */
public class Solution1984 {
    // 0. 排序(升序降序都ok)
    // 1. 穷举第i个数和第i+k-1个数的差值的绝对值
    // 2. 取最小值
    public int minimumDifference(int[] nums, int k) {
        if (k == 1 || nums.length == 0) {
            return 0;
        }

        int miniDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + k - 1;
            if (j >= nums.length) break;
            int diff = nums[j] - nums[i];
            if (diff < miniDiff) {
                miniDiff = diff;
            }
        }
        return miniDiff;
    }
}
