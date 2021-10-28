package from200;

import java.util.HashSet;

public class Solution202 {

    /**
     * 用hashSet来保存计算过的值，判断是否重复出现，若重复出现了则说明出现了循环
     */
    public boolean isHappy2(int n) {
        if (n == 0) return false;

        HashSet<Integer> set = new HashSet<>();

        while (true) {
            int squareSum = sumOfSquares(n);

            if (squareSum == 1) {
                return true;
            }

            if (set.contains(squareSum)) {
                return false;
            }

            set.add(squareSum);
            n = squareSum;
        }
    }

    private int sumOfSquares(int n) {
        int sum = 0;

        while (n > 0) {
            int remainder = n % 10;
            n /= 10;
            sum += remainder * remainder;
        }

        return sum;
    }

    /**
     *   其实问题可以转换成求是否有环，以及是否存在1
     */
    public boolean isHappy(int n) {
        // 求环的一般套路，快慢"指针"
        int slow = n, fast = n;

        do {
            // 慢指针每次循环计算一次
            slow = sumOfSquares(slow);
            // 快指针每次循环计算两次
            fast = sumOfSquares(sumOfSquares(fast));

            if (slow == 1) return true;
        } while (slow != fast);     // slow和fast相等时，表示快指针赶上了慢指针，即存在环

        return false;
    }
}
