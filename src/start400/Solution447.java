package start400;

import java.util.HashMap;
import java.util.Map;

public class Solution447 {

    /**
     * 直接使用三个循环进行距离的比较，很耗时
     * 使用空间换时间的思想
     */
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        Map<Integer, Integer> distanceCache = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;

                int xDiff = points[i][0] - points[j][0];
                int yDiff = points[i][1] - points[j][1];
                int distancePower = xDiff * xDiff + yDiff * yDiff;
                // 原来缓存中相同距离组合的个数
                int sameDistance = distanceCache.getOrDefault(distancePower, 0);

                // 由于和顺序相关，所以每出现一个相同距离的组合，就会多出sameDistance * 2排列情况
                count += sameDistance * 2;
                distanceCache.put(distancePower, sameDistance + 1);
            }

            distanceCache.clear();
        }

        return count;
    }
}
