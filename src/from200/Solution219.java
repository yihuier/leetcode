package from200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution219 {


    /**
     * 用hashMap来保存出现过的数，以及该数上一次出现的下标
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> existMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (existMap.containsKey(nums[i])) {
                if (i - existMap.get(nums[i]) <= k) return true;
            }

            existMap.put(nums[i], i);
        }

        return false;
    }

    /**
     * 使用一个set来保存出现过的数，并且保持set的size<=k
     * 此时，如果在遇到第一个重复数，set的size就是两个相同数之间的距离，因为size<=k，所以直接返回true
     * 如果是没出现过的数，则直接加入set
     * 并且判断当前set的size，如果大于k，则将当前set中第一个加入到set的数移除
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) return false;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
