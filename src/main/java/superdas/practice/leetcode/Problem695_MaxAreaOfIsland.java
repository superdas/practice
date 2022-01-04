package superdas.practice.leetcode;

public class Problem695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxIslandSize = 0;

        int iMax = grid.length;
        if (iMax == 0) {
            return 0;
        }
        int jMax = grid[0].length;
        if (jMax == 0) {
            return 0;
        }

        // For every row...
        for (int i = 0; i< grid.length; i++) {
            // For every column...
            for (int j = 0; j < grid[0].length; j++) {
                int value = grid[i][j];

                // Skip water or already visited.
                if (value != 1) {
                    continue;
                }

                // Travel island.
                int size = travel(grid, i, j, iMax, jMax);

                // Update max island size.
                if (size > maxIslandSize) {
                    maxIslandSize = size;
                }
            }
        }

        return maxIslandSize;
    }

    private int travel(int[][] grid, int i, int j, int iMax, int jMax) {
        int size = 1;
        grid[i][j] = 2;

        // up
        int up = i - 1;
        if (up >= 0 && grid[up][j] == 1) {
            size += travel(grid, up, j, iMax, jMax);
        }

        // right
        int right = j + 1;
        if (right < jMax && grid[i][right] == 1) {
            size += travel(grid, i, right, iMax, jMax);
        }

        // down
        int down = i + 1;
        if (down < iMax && grid[down][j] == 1) {
            size += travel(grid, down, j, iMax, jMax);
        }

        // left
        int left = j - 1;
        if (left >= 0 && grid[i][left] == 1) {
            size += travel(grid, i, left, iMax, jMax);
        }

        return size;
    }
}
