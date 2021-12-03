package from200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yihuier
 */
public class Solution228 {
    // todo 虽然解决了问题，但是却用到了很多的字符串转数字的操作，效率很低
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new LinkedList<>();
        if (nums.length == 0) {
            return resultList;
        }
        int prev = nums[0];
        String from = Integer.toString(prev);
        String to = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev + 1) {
                if (to == null) {
                    resultList.add(from);
                } else {
                    resultList.add(from + "->" + to);
                }
                from = Integer.toString(nums[i]);
                to = null;
                prev = nums[i];
                continue;
            }
            prev = nums[i];
            to = Integer.toString(prev);
        }
        if (to == null) {
            resultList.add(from);
        } else {
            resultList.add(from + "->" + to);
        }
        return resultList;
    }
}
