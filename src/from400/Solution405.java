package from400;

public class Solution405 {

    /**
     * num > 0 时，不断取余数
     * num < 0 时，不断无符号右移
     */
    public String toHex(int num) {
        if (num == 0) return "0";

        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                            "a", "b", "c", "d", "e", "f"};
        StringBuilder sb = new StringBuilder();

        if (num > 0) {
            while (num > 0) {
                int remainder = num % 16;
                num >>= 4;
                sb.insert(0, values[remainder]);
            }

            return sb.toString();
        }

        int bitWeight = 0;
        int sum = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                sum += 1 << bitWeight;
            }
            num >>>= 1;
            bitWeight++;
            if (bitWeight == 4) {
                sb.insert(0, values[sum]);
                bitWeight = 0;
                sum = 0;
            }
        }

        return sb.toString();
    }
}
