package start300;

public class Solution383 {

    /**
     * 由于仅限制小写字母，所以可以直接使用长度为26的数组
     * 作为一个计数器来记录每个字母出现的次数
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;

        int[] letterCounter = new int[26];

        for (char ch : magazine.toCharArray()) {
            letterCounter[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (--letterCounter[ch - 'a'] < 0) return false;
        }

        return true;
    }
}
