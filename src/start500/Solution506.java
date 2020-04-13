package start500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  @author: yihuier
 *  @Date: 2020/4/13 20:43
 *  @Description:   hashMap来记录元素下标
 */
public class Solution506 {

    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        String[] topThree = new String[]{"", "Gold Medal", "Silver Medal", "Bronze Medal"};

        // 用map来记录每个元素的下标
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // 排序
        Arrays.sort(nums);

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int rank = nums.length - i;
            int index = map.get(nums[i]);

            if (rank < topThree.length) {
                result[index] = topThree[rank];
            } else {
                result[index] = String.valueOf(rank);
            }
        }

        return result;
    }
}
