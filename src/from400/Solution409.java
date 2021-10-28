package from400;

public class Solution409 {

    /**
     * 用一个数组来保存每个字母出现的个数，然后分奇偶进行统计
     * 偶数直接加上出现个数
     * 奇数减掉1后加上个数
     */
    public int longestPalindrome(String s) {
        int[] counter = new int[58];
        int length = 0;
        // 用来标志是否出现个奇数个，为了最后加上1
        boolean flag = false;

        for (char ch : s.toCharArray()) {
            counter[ch - 'A']++;
        }

        for (int count : counter) {
            // 偶数个，直接加上个数
            if ((count & 1) == 0) {
                length += count;
                continue;
            }

            // 奇数个
            flag = true;
            length += count - 1;
        }

        if (flag) length += 1;

        return length;
    }
}
