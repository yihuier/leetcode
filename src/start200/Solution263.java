package start200;

public class Solution263 {

    /**
     * 丑数，不断用2、3、5去求余数，不能被整除的直接返回false，直到为1
     */
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        while (num > 1) {
            int x = num % 2;
            int y = num % 3;
            int z = num % 5;

            if (x != 0 && y != 0 && z != 0) return false;

            if (x == 0) {
                num /= 2;
            } else if (y == 0) {
                num /= 3;
            } else {
                num /= 5;
            }
        }

        return true;
    }
}
