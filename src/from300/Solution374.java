package from300;

import util.GuessGame;

public class Solution374 extends GuessGame {

    /**
     * 二分查找
     */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (guess(mid) == 0) return mid;
            if (guess(mid) == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // 该返回值没有是没有意义的，随意返回
        return 1;
    }
}
