class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        
        // Create result matrix initialized with -1
        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize height matrix and queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    // Water cells have height 0
                    height[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    // Mark unvisited land cells with -1
                    height[i][j] = -1;
                }
            }
        }
        
        // Directions for adjacent cells (up, right, down, left)
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // Process cells level by level using BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            // Check all adjacent cells
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check if the adjacent cell is within bounds and unvisited
                if (newRow >= 0 && newRow < m && 
                    newCol >= 0 && newCol < n && 
                    height[newRow][newCol] == -1) {
                    
                    // Assign height one more than current cell
                    height[newRow][newCol] = height[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        return height;
    }
}
