package from500;

public class Solution504 {

    /**
     * 常规做法，除n取余
     */
    public String convertToBase7(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        int tmp = num;

        num = Math.abs(num);
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }

        if (tmp < 0) sb.insert(0, "-");

        return sb.toString();
    }
}
