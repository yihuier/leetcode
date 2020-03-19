package start500;

public class Solution541 {

    /**
     * 需要进行大量的除法运算，很耗时
     */
    public String reverseStr2(String s, int k) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // k的偶数倍
            if ((((i + 1) / k) & 1) == 1) {
                result.append(s.charAt(i));
            } else {        // 奇数倍，反转字符串
                int index = (i + 1) / k * k;
                result.insert(index, s.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * 在字符数组上直接进行反转
     */
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i += 2 * k) {
            int left = i;
            int right = Math.min(left + k - 1, chs.length - 1);

            while (left < right) {
                char tmp = chs[left];
                chs[left++] = chs[right];
                chs[right--] = tmp;
            }
        }

        return new String(chs);
    }
}
