class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // Base case: if array has less than 3 elements, no Fibonacci-like subsequence exists
        if (n < 3) {
            return 0;
        }
        
        // Create a map to store the index of each value in the array for quick lookups
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        
        // dp[i][j] represents the length of Fibonacci-like subsequence ending with arr[i] and arr[j]
        int[][] dp = new int[n][n];
        int maxLength = 0;
        
        // Initialize dp array - all pairs can form a 2-element sequence
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2; // Initial length is 2 (just the pair itself)
            }
        }
        
        // Build up the dp array
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                // We're looking for arr[i] such that arr[i] + arr[j] = arr[k]
                // This means arr[i] = arr[k] - arr[j]
                int prev = arr[k] - arr[j];
                
                // If prev is in the array and comes before arr[j]
                if (prev < arr[j] && indexMap.containsKey(prev)) {
                    int i = indexMap.get(prev);
                    
                    // Update the dp value at j,k by extending the sequence from i,j
                    dp[j][k] = dp[i][j] + 1;
                    
                    // Update the maximum length
                    maxLength = Math.max(maxLength, dp[j][k]);
                }
            }
        }
        
        // Return 0 if no sequence of length >= 3 was found, otherwise return the max length
        return maxLength >= 3 ? maxLength : 0;
    }
}