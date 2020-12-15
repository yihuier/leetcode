package start1400;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author yihuier
 *  @Date 2020/12/15 11:18
 *  @Description
 */
public class Solution1431 {

    /**
     * 先求最大值，然后比较extraCandies+candies[i]与最大值
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}
