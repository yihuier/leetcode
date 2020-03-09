package start200;

public class Solution258 {

    public int addDigits2(int num) {

        while (num >= 10) {
            int tmp = 0;
            while (num > 0) {
                tmp += (num % 10);
                num /= 10;
            }

            num = tmp;
        }

        return num;
    }

    /**
     * 找规律，发现当 num != 0，结果为 num % 9 的值
     */
    public int addDigits(int num) {
        if (num < 10) return num;

        num %= 9;
        if (num == 0) return 9;

        return num;
    }
}
