package start600;

/**
 *  @author yihuier
 *  @Date 2021/02/26 22:10
 *  @Description 计算最大相邻1的和
 */
public class Solution695 {

    public int maxAreaOfIsland(int[][] grid) {
        // 标记已经检测过的位置
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 如果还没有标记过
                if (!flag[i][j]) {
                    int area = fourDirectionArea(grid, flag, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    /**
     * 递归判断以及求和
     */
    private int fourDirectionArea(int[][] grid, boolean[][] flag, int i, int j) {
        // 超出界限视为0
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return 0;
        }

        // 本身为0或者已经标记过了
        if (grid[i][j] == 0 || flag[i][j]) {
            return 0;
        }

        // 标记
        flag[i][j] = true;

        int area = 1;

        // 上 
        area += fourDirectionArea(grid, flag, i - 1, j);
        // 下
        area += fourDirectionArea(grid, flag, i + 1, j);
        // 左
        area += fourDirectionArea(grid, flag, i, j - 1);
        // 右
        area += fourDirectionArea(grid, flag, i, j + 1);
        
        return area;
    }
}