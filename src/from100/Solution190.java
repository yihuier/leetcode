package from100;

public class Solution190 {

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // 求最右边的位（即当前最低位）是0还是1
            int currentBit = n & 1;
            n = n >> 1;
            // 如果i == 31 说明已经移动到了最后一个位，求或之后不需要在左移了
            result = i < 31 ?  (result | currentBit) << 1 : (result | currentBit);
        }

        return result;
    }
}
