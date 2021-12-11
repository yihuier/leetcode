package from600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yihuier
 */
public class Solution697 {
    // 这里记录了所有下边的位置，其实也可以只记录第一次出现的位置和最后一次出现的位置
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = counterMap.getOrDefault(nums[i], 0) + 1;
            maxCount = Math.max(maxCount, count);
            counterMap.put(nums[i], count);
            if (indexMap.containsKey(nums[i])) {
                indexMap.get(nums[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                indexMap.put(nums[i], indexList);
            }
        }
        int smallestLength = Integer.MAX_VALUE;
        for (Integer key : counterMap.keySet()) {
            if (maxCount == counterMap.get(key)) {
                List<Integer> numberIndexList = indexMap.get(key);
                int startIndex = numberIndexList.get(0);
                int endIndex = numberIndexList.get(numberIndexList.size() - 1);
                smallestLength = Math.min(smallestLength, endIndex - startIndex + 1);
            }
        }

        return smallestLength;
    }
}
