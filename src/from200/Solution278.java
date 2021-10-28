package from200;

public class Solution278 {

    /**
     * 二分查找的变体，查找第一个符合要求的数
     */
    public int firstBadVersion2(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1)) return mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * 为了让isBadVersion调用次数更少
     */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low < high) {
            int mid = low + ((high - low) >> 1);

            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * 一个假的方法，实际方法由LeetCode提供
     */
    private boolean isBadVersion(int version) {
        return true;
    }
}
