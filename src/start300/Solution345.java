package start300;

public class Solution345 {

    /**
     * 通过头尾指针来交换原因字母
     */
    public static String reverseVowels(String s) {
        if (s == null) return null;

        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();

        while (low <= high) {
            while (low < high && !isVowel(chars[low])) {
                low++;
            }

            while (low < high && !isVowel(chars[high])) {
                high--;
            }

            if (low >= high) break;

            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;

            low++;
            high--;
        }

        return new String(chars);
    }

    private static boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
