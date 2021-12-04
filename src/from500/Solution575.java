package from500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yihuier
 */
public class Solution575 {
    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length == 0) {
            return 0;
        }
        Arrays.sort(candyType);
        int prev = candyType[0];
        int diffTypeCount = 1;
        for (int type : candyType) {
            if (prev != type) {
                diffTypeCount += 1;
                prev = type;
            }
        }
        int canEatNum = candyType.length / 2;
        return Math.min(diffTypeCount, canEatNum);
    }

    public int distributeCandiesWithSet(int[] candyType) {
        if (candyType == null || candyType.length == 0) {
            return 0;
        }
        Set<Integer> typeSet = new HashSet<>();
        for (int type : candyType) {
            typeSet.add(type);
        }
        int canEatNum = candyType.length / 2;
        return Math.min(typeSet.size(), canEatNum);
    }
}
