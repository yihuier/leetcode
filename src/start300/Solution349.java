package start300;

import java.util.*;

public class Solution349 {

    /**
     * 先排序，然后遍历保存相同的值
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
                    // 去掉已经存在的元素
                    if (count != 0 && tmp[count - 1] == num) continue;
                    tmp[count++] = num;
                }
            }
        }

        int[] result = new int[count];
        System.arraycopy(tmp, 0, result, 0, count);

        return result;
    }
}
