package from500;

public class Solution507 {

    /**
     * 暴力啊
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;

        int mid = num / 2;
        int sum = 0;

        for (int i = 1; i <= mid; i++) {
            if (num % i == 0) sum += i;
        }

        return sum == num;
    }
}
