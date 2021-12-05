package from500;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yihuier
 */
public class Solution594 {
    // 借助一个map来保存数组中每个数出现的次数，再遍历一遍map的所有key，求出差值为1的key出现个数的和
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                maxLength = Math.max(maxLength, map.get(key) + map.get(key + 1));
            }
        }
        return maxLength;
    }
}
