class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        
        // Use PriorityQueue to store the boundary cells
        // The queue will store cells as [row, col, height]
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];
        
        // Add all border cells to priority queue
        // Add first and last row
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m-1, j, heightMap[m-1][j]));
            visited[0][j] = true;
            visited[m-1][j] = true;
        }
        // Add first and last column
        for (int i = 1; i < m-1; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n-1, heightMap[i][n-1]));
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        
        // Directions for exploring neighbors (up, right, down, left)
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int waterTrapped = 0;
        
        // Process cells from lowest to highest
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            
            // Check all neighboring cells
            for (int[] dir : dirs) {
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];
                
                // Skip if out of bounds or already visited
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }
                
                // If the neighbor is lower than current cell's height,
                // it will trap water up to current cell's height
                if (heightMap[newRow][newCol] < curr.height) {
                    waterTrapped += curr.height - heightMap[newRow][newCol];
                }
                
                // Add neighbor to queue with its effective height
                // (either its original height or current cell's height, whichever is higher)
                pq.offer(new Cell(newRow, newCol, 
                    Math.max(heightMap[newRow][newCol], curr.height)));
                visited[newRow][newCol] = true;
            }
        }
        
        return waterTrapped;
    }
    
    // Helper class to store cell information
    private static class Cell {
        int row;
        int col;
        int height;
        
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}