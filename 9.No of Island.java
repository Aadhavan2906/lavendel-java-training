import java.util.ArrayList;
import java.util.List;

class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        int numIslands = countIslands(grid);
        System.out.println(numIslands); // Output: 1
    }

    private static int countIslands(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == 1) {
                    numIslands++;
                    dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }

    private static void dfs(int[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 0; // Mark the current cell as visited
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}