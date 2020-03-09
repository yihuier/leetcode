package start300;

public class Solution367 {

    /**
     * 二分查找
     */
    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long low = 1;
        long high = num / 2;

        while (low <= high) {
            // 注意这里的mid要为long，否则mid * mid的结果超出int范围将会导致结果出错
            long mid = low + ((high - low) >> 1);
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
