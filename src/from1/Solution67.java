package from1;

public class Solution67 {

    public String addBinary(String a, String b) {
        int len = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
        int[] result = new int[len];
        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = len - 1;
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            if (sum > 1) {
                result[k] = sum & 1;
                carry = 1;
            } else {
                result[k] = sum;
                carry = 0;
            }
            i--;
            j--;
            k--;
        }

        String c = (a.length() > b.length() ? a : b);
        int m = i > j ? i : j;
        while (m >= 0) {
            int sum = (c.charAt(m) - '0') + carry;
            if (sum > 1) {
                result[k] = sum & 1;
                carry = 1;
            } else {
                result[k] = sum;
                carry = 0;
            }
            k--;
            m--;
        }
       result[0] = carry;

        StringBuilder sb = new StringBuilder();
        i = 0;
        while (result[i] == 0 && i != result.length - 1) {
            i++;
        }
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
