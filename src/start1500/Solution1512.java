package start1500;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author yihuier
 *  @Date 2020/12/16 10:21
 *  @Description
 */
public class Solution1512 {

    public int numIdenticalPairs(int[] nums) {
        int pairsNum = 0;
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            int count = counter.getOrDefault(num, 0);
            counter.put(num, count + 1);
        }

        for (Integer count : counter.values()) {
            if (count == 1) {
                continue;
            }
            pairsNum += (count - 1) * count / 2;
        }

        return pairsNum;
    }
}
