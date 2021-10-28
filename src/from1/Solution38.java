package from1;

public class Solution38 {

    public String countAndSay(int n) {
        return recurse(1, n, "1");
    }

    private String recurse(int k, int n, String str) {
        if (k == n) return str;

        char c = str.charAt(0);
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (c == str.charAt(i))
                count++;
            else {
                sb.append(count);
                sb.append(c);
                c = str.charAt(i);
                count = 1;
            }

            if (i + 1 == str.length()) {
                sb.append(count);
                sb.append(c);
            }
        }

        return recurse(k + 1, n, sb.toString());
    }
}
