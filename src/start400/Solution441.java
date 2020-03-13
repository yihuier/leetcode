package start400;

public class Solution441 {

    /**
     * 不断减去每一层的个数，直到不够减
     */
    public int arrangeCoins(int n) {
        if (n == 0) return 0;

        int count = 1;

        while (n >= count) {
            n -= count;
            count++;
        }

        return --count;
    }

    //TODO 还有更好的解题方法
}
