package superdas.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        IslandSize maxIslandSize = new IslandSize(0);
        Map<Integer, IslandSize> islandIdToSize = new HashMap<>();
        NextIslandId nextIslandId = new NextIslandId();

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // For every row...
        for (int i = 0; i < grid.length; i++) {
            // For every column...
            for (int j = 0; j < grid[0].length; j++) {
                int value = grid[i][j];

                // Skip water.
                if (value == 0) {
                    continue;
                }

                // Get island size.
                IslandSize islandSize =
                        getIslandSize(grid, i, j, islandIdToSize, nextIslandId);

                // Set island ID.
                grid[i][j] = islandSize.id();

                // Update island size.
                islandSize.increment();

                // Update max island size.
                if (islandSize.size() > maxIslandSize.size()) {
                    maxIslandSize = islandSize;
                }
            }
        }

        return maxIslandSize.size();
    }

    private static IslandSize getIslandSize(
            int[][] grid, int i, int j,
            Map<Integer, IslandSize> islandIdToSize, NextIslandId nextIslandId) {

        int topIslandId = 0;
        IslandSize topIslandSize = null;
        // Check top if not top-most row.
        if (i > 0) {
            topIslandId = grid[i - 1][j];
            topIslandSize = islandIdToSize.get(topIslandId);
        }

        int leftIslandId = 0;
        IslandSize leftIslandSize = null;
        // Check left if not left-most row.
        if (j > 0) {
            leftIslandId = grid[i][j - 1];
            leftIslandSize = islandIdToSize.get(leftIslandId);
        }

        // Merge islands if adjacent to two different islands.
        if (topIslandId > 0 && leftIslandId > 0 && topIslandId != leftIslandId) {
            if (!topIslandSize.islandIds.contains(leftIslandId)) {
                leftIslandSize.size += topIslandSize.size;
                leftIslandSize.islandIds.addAll(topIslandSize.islandIds);
                for (int islandId : topIslandSize.islandIds) {
                    islandIdToSize.put(islandId, leftIslandSize);
                }
            }
            return leftIslandSize;
        } else if (leftIslandId > 0) {
            return leftIslandSize;
        } else if (topIslandId > 0) {
            return topIslandSize;
        }

        int islandId = nextIslandId.next();
        IslandSize islandSize = new IslandSize(islandId);
        islandIdToSize.put(islandId, islandSize);
        return islandSize;
    }

    private static class IslandSize {
        int primaryIslandId;
        Set<Integer> islandIds = new HashSet<>();
        int size = 0;

        IslandSize(int islandId) {
            this.primaryIslandId = islandId;
            islandIds.add(islandId);
        }

        int id() {
            return primaryIslandId;
        }

        int size() {
            return size;
        }

        void increment() {
            size++;
        }
    }

    private static class NextIslandId {
        int nextIslandId = 2;

        int next() {
            return nextIslandId++;
        }
    }
}
