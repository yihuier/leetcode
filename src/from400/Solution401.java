package from400;

import java.util.ArrayList;
import java.util.List;

public class Solution401 {

    /**
     * 求出所有可能的组合情况，去掉非法数据
     */
    public List<String> readBinaryWatch(int num) {
        // 0 <= num <= 10
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            if (num - i <= 6) {
                List<Integer> hourList = hourList(i);
                List<Integer> minuteList = minuteList(num - i);

                for (Integer hour : hourList)
                    for (Integer minute : minuteList)
                        if (hour <= 11 && minute <= 59)
                            resultList.add(composite(hour, minute));
            }
        }
        return resultList;
    }

    /**
     * 指定led数量，求出可能的小时
     */
    private List<Integer> hourList(int num) {
        List<Integer> hourList = new ArrayList<>();
        int[] hourMap = {1, 2, 4, 8};
        boolean[] used = new boolean[4];

        addHour(num, used, hourMap, hourList, 0);

        return hourList;
    }

    /**
     * 递归将求出每种可能led组合
     * 这里的参数i，用来防止重复计算，因为属于组合而不是排列
     */
    private void addHour(int num, boolean[] used, int[] hourMap, List<Integer> hourList, int i) {
        if (num == 0) {
            hourList.add(compute(used, hourMap));
            return;
        }

        for (; i < hourMap.length; i++) {
            if (!used[i]) {
                used[i] = true;
                addHour(num - 1, used, hourMap, hourList, i + 1);
                used[i] = false;
            }
        }
    }

    /**
     * 指定led数量，求出可能的分钟
     */
    private List<Integer> minuteList(int num) {
        List<Integer> minuteList = new ArrayList<>();
        int[] minuteMap = {1, 2, 4, 8, 16, 32};
        boolean[] used = new boolean[6];

        addMinute(num, used, minuteMap, minuteList, 0);

        return minuteList;
    }

    /**
     * 递归将求出每种可能led组合
     * 这里的参数i，用来防止重复计算，因为属于组合而不是排列
     */
    private void addMinute(int num, boolean[] used, int[] minuteMap, List<Integer> minuteList, int i) {
        if (num == 0) {
            minuteList.add(compute(used, minuteMap));
            return;
        }

        for (; i < minuteMap.length; i++) {
            if (!used[i]) {
                used[i] = true;
                addMinute(num - 1, used, minuteMap, minuteList, i + 1);
                used[i] = false;
            }
        }
    }

    /**
     * 计算小时或者分钟
     */
    private int compute(boolean[] used, int[] map) {
        int sum = 0;

        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                sum += map[i];
            }
        }

        return sum;
    }

    /**
     * 将小时和分钟组合成字符串
     */
    private String composite(Integer hour, Integer minute) {
        if (minute < 10) return hour + ":" + "0" + minute;

        return hour + ":" + minute;
    }
}

