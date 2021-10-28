package from400;


public class Solution414 {

    /**
     * 用三个变量来保存最大的前三个值
     * 用long的最小值来表示还没有被赋值过
     * 但是这个做法有点治标不治本的意思
     * 如果参数是long数组呢，用什么来表示还没有被赋值过
     */
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            if (num >= firstMax) {
                if (num > firstMax) {
                    thirdMax = secondMax;
                    secondMax = firstMax;
                    firstMax = num;
                }
            } else if (num >= secondMax) {
                if (num > secondMax) {
                    thirdMax = secondMax;
                    secondMax = num;
                }
            } else if (num >= thirdMax) {
                if (num > thirdMax) {
                    thirdMax = num;
                }
            }
        }

        return thirdMax == Long.MIN_VALUE ? (int) firstMax : (int) thirdMax;
    }
}
