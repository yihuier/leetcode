package start300;

/**
 * 和383题的思路几乎一样
 */
public class Solution387 {

    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] letterCounter = new int[26];
        int[] letterFirstIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (letterCounter[ch - 'a']++ == 0) {
               letterFirstIndex[ch - 'a'] = i;
            }
        }

        int index = -1;
        for (int i = 0; i < letterCounter.length; i++) {
            if (letterCounter[i] == 1) {
                if (index == -1 || index > letterFirstIndex[i])
                    index = letterFirstIndex[i];
            }
        }

        return index;
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] letterCounter = new int[26];

        for (char ch : s.toCharArray()) {
            letterCounter[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (letterCounter[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
