package start100;

public class Solution191 {

    /**
     * 对n不断的左移并判断此时最低位是否为1
     */
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }

        return count;
    }
}
