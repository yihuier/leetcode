package from600;

import java.util.Arrays;

/**
 * @author yihuier
 */
public class Solution628 {
    // 或者可以遍历一遍，记录下来最小两个数和最大的三个数，然后如下比较乘积的大小
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
