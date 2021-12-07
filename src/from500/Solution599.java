package from500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yihuier
 */
public class Solution599 {
    private int minIndexSum = Integer.MAX_VALUE;

    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> commonInterestRestaurants = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int indexSum = map.get(list2[i]) + i;
                if (indexSum < minIndexSum) {
                    commonInterestRestaurants.clear();
                    commonInterestRestaurants.add(list2[i]);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    commonInterestRestaurants.add(list2[i]);
                }
            }
        }
        String[] result = new String[commonInterestRestaurants.size()];
        commonInterestRestaurants.toArray(result);
        return result;
    }
}
