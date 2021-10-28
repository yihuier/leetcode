package from500;

import java.util.Arrays;

public class Solution532 {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return 0;

        Arrays.sort(nums);

        int count = 0;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            int distance = nums[right] - nums[left];

            if (distance < k) {
                right++;
            } else {
                if (distance == k) count++;

                // 过滤掉相同的数
                while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;

                // 保证right一直在left后面
                if (left >= right) right = left + 1;
            }
        }

        return count;
    }
}
