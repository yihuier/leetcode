package start1;

public class Solution66 {

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            if (digits[i] > 9 && i != 0) {
                digits[i] = 0;
            } else {
                break;
            }
        }

        if (digits[0] > 9) {
            digits[0] = 0;
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            digits = result;
        }

        return digits;
    }
}
