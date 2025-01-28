class Solution {
    private int m, n;
    private boolean[][] visited;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int findMaxFish(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int maxFish = 0;
        
        // Try each cell as starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {  // If it's a water cell with fish
                    // Reset visited array for each new starting point
                    visited = new boolean[m][n];
                    maxFish = Math.max(maxFish, dfs(i, j, grid));
                }
            }
        }
        
        return maxFish;
    }
    
    private int dfs(int row, int col, int[][] grid) {
        // Base cases: out of bounds or already visited or land cell
        if (row < 0 || row >= m || col < 0 || col >= n || 
            visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        
        // Mark current cell as visited
        visited[row][col] = true;
        int currentFish = grid[row][col];
        
        // Explore all adjacent water cells
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            currentFish += dfs(newRow, newCol, grid);
        }
        
        return currentFish;
    }
}