class Solution {
    private int n;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private Map<Integer, Integer> islandSizes = new HashMap<>();
    
    public int largestIsland(int[][] grid) {
        n = grid.length;
        int islandId = 2; // Start with 2 as island marker since grid contains 0s and 1s
        int maxSize = 0;
        
        // First pass: Mark each island with unique id and calculate its size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSizes.put(islandId, size);
                    maxSize = Math.max(maxSize, size);
                    islandId++;
                }
            }
        }
        
        // Handle case where grid is all 1s
        if (maxSize == n * n) return maxSize;
        
        // Second pass: Try to convert each 0 to 1 and calculate resulting island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborIslands = new HashSet<>();
                    // Check all 4 directions
                    for (int[] dir : directions) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (isValid(newRow, newCol) && grid[newRow][newCol] > 1) {
                            neighborIslands.add(grid[newRow][newCol]);
                        }
                    }
                    
                    // Calculate size if we convert this 0 to 1
                    int currentSize = 1; // Start with 1 for the cell we're converting
                    for (int id : neighborIslands) {
                        currentSize += islandSizes.get(id);
                    }
                    maxSize = Math.max(maxSize, currentSize);
                }
            }
        }
        
        return maxSize;
    }
    
    private int dfs(int[][] grid, int row, int col, int islandId) {
        if (!isValid(row, col) || grid[row][col] != 1) {
            return 0;
        }
        
        grid[row][col] = islandId; // Mark as visited with island id
        int size = 1;
        
        // Explore all 4 directions
        for (int[] dir : directions) {
            size += dfs(grid, row + dir[0], col + dir[1], islandId);
        }
        
        return size;
    }
    
    private boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}