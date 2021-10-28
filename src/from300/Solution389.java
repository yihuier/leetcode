package from300;

public class Solution389 {

    /**
     * 还是和383一样的思路
     */
    public char findTheDifference(String s, String t) {
        int[] letterCounter = new int[26];

        for (char ch : t.toCharArray()) {
            letterCounter[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            letterCounter[ch - 'a']--;
        }

        for (int i = 0; i < letterCounter.length; i++) {
            if (letterCounter[i] != 0)
                return (char)('a' + i);
        }

        // 随意的返回值
        return 'a';
    }
}
