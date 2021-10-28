package from300;

import java.util.Arrays;

public class Solution350 {

    /**
     * 思路和349差不多
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] tmp = new int[nums1.length > nums2.length ? nums2.length: nums1.length];

        int j = 0;
        int count = 0;
        for (int num : nums1) {
            for (; j < nums2.length; j++) {
                if (num < nums2[j]) break;

                if (num == nums2[j]) {
                    tmp[count++] = num;
                    // 注意这里要j++和break
                    j++;
                    break;
                }
            }
        }

        int[] result = new int[count];
        System.arraycopy(tmp, 0, result, 0, count);

        return result;
    }
}
