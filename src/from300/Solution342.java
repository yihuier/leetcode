package from300;

public class Solution342 {

    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;

        while (num > 1) {
            if (num % 4 != 0) return false;
            num /= 4;
        }

        return true;
    }
}
