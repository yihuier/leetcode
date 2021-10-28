package from400;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author yihuier
 *  @Date 2020/12/1 17:55
 *  @Description
 */
public class Solution496 {

    /**
     * 用nextGreaterMap来保存num2中元素右边的下一个较大值
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 0 || nums1.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums1.length];
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {
                    nextGreaterMap.put(nums2[i], nums2[j]);
                    break;
                }
            }
            // 这里要注意如果没有下一个较大值要设置为-1
            nextGreaterMap.putIfAbsent(nums2[i], -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
