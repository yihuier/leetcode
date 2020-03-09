package start200;

public class Solution231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        boolean flag = false;

        while (n != 0) {
            if ((n & 1) == 1) {
                if (flag) return false;
                flag = true;
            }
            n >>= 1;
        }

        return true;
    }
}
