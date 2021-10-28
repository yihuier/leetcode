package from100;

public class Solution168 {

    public static String convertToTitle(int n) {
        if (n <= 0) return "";

        String[] container = new String[] {"Z", "A", "B", "C", "D" ,"E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};
        int len = container.length;
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % len;
            sb.insert(0, container[remainder]);
            n /= len ;
            if (remainder == 0) {
                n -= 1;
            }
        }

        return sb.toString();
    }
}
