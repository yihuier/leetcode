package from400;

public class Solution453 {

    /**
     * 将问题转换为每移动一次，有一个元素减1，所以只要所有元素减到和最小值一样就可以了
     * 下面的做法是两次循环，也可以在一次循环中统计最小值个数以及所有元素的和
     * 最后在减去最小值的和。
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int moves = 0;

        for (int num : nums) {
            if (num < min) min = num;
        }

        for (int num : nums) {
            if (num > min) moves += num - min;
        }

        return moves;
    }
}
