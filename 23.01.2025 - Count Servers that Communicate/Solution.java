class Solution {
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        // Count servers in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        // First pass: Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        // Second pass: Count servers that can communicate
        int communicatingServers = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If server exists and is not the only server in its row or column
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    communicatingServers++;
                }
            }
        }
        
        return communicatingServers;
    }
}