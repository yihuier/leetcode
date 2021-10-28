package from300;

public class Solution392 {

    /**
     * 直接遍历
     */
    public boolean isSubsequence(String s, String t) {
        int j = 0;

        for (char ch : t.toCharArray()) {
            if (j >= s.length()) break;

            if (s.charAt(j) == ch) j++;
        }

        return s.length() == j;
    }
}
