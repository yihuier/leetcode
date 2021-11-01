package from900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yihuier
 */
public class Solution935 {
    private static final int[][] phonePad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    private static final int ROW_MAX = 3;
    private static final int ROW_MIN = 0;
    private static final int COL_MAX = 2;
    private static final int COL_MIN = 0;
    private static final Map<Integer, List<Integer>> nextValidJumpMap = new HashMap<>();
    private static final int MODULO_NUMBER = 1000000007;

    // 动态规划：
    //      0: 生成每一个位置的下一次可jump的位置列表
    //      1: 分为n个阶段，每个阶段共有0~9这10种可能，
    //         定义states[n][number], n表示第几次jump, number表示当前所在的位置, 而states[n][number]的值表示第n次jump时刚好在number的可能的情况
    //      2: 根据上一个阶段的所有状态，推算出本阶段的所有状态
    //      3: 将最后一个阶段中所有可能情况累加
    public int knightDialer(int n) {
        if (n == 0) return 0;
        int result = 0;
        buildJumpMap();
        int[][] states = new int[n][10];
        for (int j = 0; j < 10; j++) {
            states[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                if (states[i - 1][j] != 0) {
                    List<Integer> nextJumps = nextValidJumpMap.get(j);
                    for (Integer nextJump : nextJumps) {
                        states[i][nextJump] += states[i - 1][j];
                        if (states[i][nextJump] >= MODULO_NUMBER) {
                            states[i][nextJump] %= MODULO_NUMBER;
                        }
                    }
                }
            }
        }
        for (int j = 0; j < 10; j++) {
            result = (result + states[n - 1][j]) % MODULO_NUMBER;
        }
        return result;
    }

    private void buildJumpMap() {
        for (int row = 0; row < phonePad.length; row++) {
            for (int col = 0; col < phonePad[row].length; col++) {
                if (phonePad[row][col] != -1) {
                    List<Integer> newValidJumps = new ArrayList<>();
                    int rowVerticalUp1 = row - 1;
                    int rowVerticalUp2 = row - 2;
                    int rowVerticalDown1 = row + 1;
                    int rowVerticalDown2 = row + 2;
                    int colHorizontalLeft1 = col - 1;
                    int colHorizontalLeft2 = col - 2;
                    int colHorizontalRight1 = col + 1;
                    int colHorizontalRight2 = col + 2;
                    if (valid(rowVerticalUp2, colHorizontalLeft1)) {
                        newValidJumps.add(phonePad[rowVerticalUp2][colHorizontalLeft1]);
                    }
                    if (valid(rowVerticalUp2, colHorizontalRight1)) {
                        newValidJumps.add(phonePad[rowVerticalUp2][colHorizontalRight1]);
                    }
                    if (valid(rowVerticalDown2, colHorizontalLeft1)) {
                        newValidJumps.add(phonePad[rowVerticalDown2][colHorizontalLeft1]);
                    }
                    if (valid(rowVerticalDown2, colHorizontalRight1)) {
                        newValidJumps.add(phonePad[rowVerticalDown2][colHorizontalRight1]);
                    }
                    if (valid(rowVerticalUp1, colHorizontalLeft2)) {
                        newValidJumps.add(phonePad[rowVerticalUp1][colHorizontalLeft2]);
                    }
                    if (valid(rowVerticalDown1, colHorizontalLeft2)) {
                        newValidJumps.add(phonePad[rowVerticalDown1][colHorizontalLeft2]);
                    }
                    if (valid(rowVerticalUp1, colHorizontalRight2)) {
                        newValidJumps.add(phonePad[rowVerticalUp1][colHorizontalRight2]);
                    }
                    if (valid(rowVerticalDown1, colHorizontalRight2)) {
                        newValidJumps.add(phonePad[rowVerticalDown1][colHorizontalRight2]);
                    }
                    nextValidJumpMap.put(phonePad[row][col], newValidJumps.stream().sorted().collect(Collectors.toList()));
                }
            }
        }
    }

    private boolean valid(int row, int col) {
        return row <= ROW_MAX && row >= ROW_MIN && col <= COL_MAX && col >= COL_MIN && phonePad[row][col] != -1;
    }
}
