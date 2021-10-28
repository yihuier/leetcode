package from200;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {

    /**
     * 使用hashSet来保存出现过的数字
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return false;

        Set<Integer> exists = new HashSet<>();

        for (int num : nums) {
            if (!exists.add(num)) return true;
        }

        return false;
    }
}
