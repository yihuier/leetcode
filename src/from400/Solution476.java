package from400;

public class Solution476 {

    /**
     * 通过一个bit来从低位到高位检测num对应位是1还是0
     */
    public int findComplement(int num) {
        if (num == 0) return 1;
        int result = 0;
        int bit = 1;

        // bit >= 0 用来防止bit中的1移到最高位
        while (num >= bit && bit >= 0) {
            if ((num & bit) == 0) {
                result |= bit;
            }

            bit <<= 1;
        }

        return result;
    }
}
