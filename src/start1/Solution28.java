package start1;

public class Solution28 {

    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) return -1;
        if ("".equals(needle)) return 0;

        char[] chars = haystack.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == needle.charAt(0)) {
                int k = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (k >= chars.length || chars[k] != needle.charAt(j)) {
                        break;
                    }
                    k++;
                }
                if (k - i == needle.length()) return i;
            }
        }
        return -1;
    }
}
