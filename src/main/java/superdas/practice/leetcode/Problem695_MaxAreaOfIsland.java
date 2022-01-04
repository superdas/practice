package superdas.practice.leetcode;

public class Problem695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxIslandSize = 0;
        int nextIslandId = 2;

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // For every row...
        for (int i = 0; i < grid.length; i++) {
            // For every column...
            for (int j = 0; j < grid[0].length; j++) {
                int value = grid[i][j];

                // Skip water or already visited.
                if (value != 1) {
                    continue;
                }

                // Get island ID.
                int islandId = nextIslandId++;

                // Travel island.
                int size = travel(grid, i, j, islandId);

                // Update max island size.
                if (size > maxIslandSize) {
                    maxIslandSize = size;
                }
            }
        }

        return maxIslandSize;
    }

    private int travel(int[][] grid, int i, int j, int islandId) {
        if (grid[i][j] != 1) {
            return 0;
        }

        int size = 1;
        grid[i][j] = islandId;

        // up
        if (i - 1 >= 0) {
            size += travel(grid, i - 1, j, islandId);
        }

        // right
        if (j + 1 < grid[0].length) {
            size += travel(grid, i, j + 1, islandId);
        }

        // down
        if (i + 1 < grid.length) {
            size += travel(grid, i + 1, j, islandId);
        }

        // left
        if (j - 1 >= 0) {
            size += travel(grid, i, j - 1, islandId);
        }

        return size;
    }
}
