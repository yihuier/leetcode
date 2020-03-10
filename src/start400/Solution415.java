package start400;

public class Solution415 {

    /**
     * 从后往前逐位相加，注意进位
     */
    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        int carry = 0;

        while (num1Index >= 0 || num2Index >= 0) {
            int sum = (num1Index >= 0 ? num1.charAt(num1Index) - '0' : 0)
                    + (num2Index >= 0 ? num2.charAt(num2Index) - '0' : 0)
                    + carry;
            carry = 0;

            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            }

            sb.append(sum);

            num1Index--;
            num2Index--;
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
