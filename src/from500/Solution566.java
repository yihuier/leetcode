package from500;

/**
 * @author yihuier
 */
public class Solution566 {
    // 里面用到了 / % 运算，效率会比较低, 可以考虑不使用 / %运算来计算位置
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat == null || mat.length == 0 || mat[0].length == 0 || mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] newMat = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int index = i * mat[i].length + j;
                int newRow = index / c;
                int newCol = index % c;
                newMat[newRow][newCol] = mat[i][j];
            }
        }
        return newMat;
    }
}
