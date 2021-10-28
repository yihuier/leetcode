package from400;

public class Solution463 {

    public int islandPerimeter(int[][] grid) {
        int islandNum = 0;
        int inlineEdge = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islandNum++;
                    inlineEdge += inlineEdge(grid, i, j);
                }
            }
        }

        return islandNum * 4 - inlineEdge;
    }

    private int inlineEdge(int[][] grid, int i, int j) {
        int inlineEdge = 0;

        if (i > 0 && grid[i - 1][j] == 1) inlineEdge++;
        if (j < grid[i].length - 1 && grid[i][j + 1] == 1) inlineEdge++;
        if (i < grid.length - 1 && grid[i + 1][j] == 1) inlineEdge++;
        if (j > 0 && grid[i][j - 1] == 1) inlineEdge++;

        return inlineEdge;
    }
}
