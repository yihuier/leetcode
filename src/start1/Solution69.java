package start1;

public class Solution69 {

    /**
     * 使用二分查找变体
     */
    public int mySqrt(int x) {
        int mid = 0;
        int low = 1;
        int high = x;

        while (low <= high) {
            mid = low + ((high - low) >> 1);

            // 用除法避免乘方溢出
            if (x / mid == mid) return mid;
            if (x / mid > mid) {
                // 由于对于结果是小数的向下取整数所以这种情况直接返回mid
                if (x / (mid + 1) < mid + 1) return mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return mid;
    }

    public void main() {

    }
}
