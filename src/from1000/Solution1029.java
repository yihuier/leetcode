package from1000;

import java.util.Arrays;

/**
 * @author yihuier
 */
public class Solution1029 {
    // 很明显，如果使用列举所有情况的方式来解决将会花费大量的时间
    // 因此，这里我们考虑使用贪心算法。
    // 0. 假设所有的人都去城市a，计算出费用cost
    // 1. 此时，这些人中有一半的人是要去城市b的，所以我们考虑选择那些去城市b费用低于去城市a费用的人
    //    因为，这样我们就可以减少我们的费用cost，当然，如果所有去城市b的费用都高于去城市a的费用
    //    那么，我们就选择去城市b费用较小的，以尽可能少的增加cost。（即选择costB-costA最小的前n个人去城市b）
    // 2. 那么要选哪些人去城市b呢，首先，我们计算出去城市b与去城市a之间的差值，然后排序，取出前n个人去城市b
    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;
        int[] diffs = new int[costs.length];
        int n = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            minCost += costs[i][0];
            diffs[i] = costs[i][1] - costs[i][0];
        }
        Arrays.sort(diffs);
        for (int i = 0; i < n; i++) {
            minCost += diffs[i];
        }
        return minCost;
    }
}
