package from500;

/**
 * @author yihuier
 */
public class Solution598 {
    // 因为只需要求最终形态的矩阵中数值最大的个数，所以只需要求所有ops的交集即可
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for (int i = 0; i < ops.length; i++) {
            minRow = Math.min(minRow, ops[i][0]);
            minCol = Math.min(minCol, ops[i][1]);
        }
        return minRow * minCol;
    }
}
