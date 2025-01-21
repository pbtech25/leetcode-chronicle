class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        // Use long to handle large sums
        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];
        
        // Calculate prefix sums for both rows
        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];
        
        for (int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i-1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i-1] + grid[1][i];
        }
        
        long result = Long.MAX_VALUE;
        
        // For each possible turning point of first robot
        for (int i = 0; i < n; i++) {
            // Calculate what second robot can get
            // Second robot will choose maximum of:
            // 1. Remaining elements in top row after first robot's turning point
            // 2. Elements in bottom row before first robot's turning point
            
            long topRemainder = topPrefix[n-1] - topPrefix[i];
            long bottomRemainder = (i > 0) ? bottomPrefix[i-1] : 0;
            
            // Second robot will choose the maximum path
            long secondRobotScore = Math.max(topRemainder, bottomRemainder);
            
            // First robot wants to minimize second robot's score
            result = Math.min(result, secondRobotScore);
        }
        
        return result;
    }
}