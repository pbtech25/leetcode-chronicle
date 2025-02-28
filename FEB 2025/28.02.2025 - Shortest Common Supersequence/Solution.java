class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // If either string is empty, return the other string
        if (str1.length() == 0) return str2;
        if (str2.length() == 0) return str1;
        
        // Optimization for identical strings
        if (str1.equals(str2)) return str1;
        
        // Special case for repetitive characters
        if (isRepeatedChar(str1) && isRepeatedChar(str2) && str1.charAt(0) == str2.charAt(0)) {
            // Both strings consist of the same repeated character
            int maxLength = Math.max(str1.length(), str2.length());
            return str1.substring(0, 1).repeat(maxLength);
        }
        
        int m = str1.length();
        int n = str2.length();
        
        // Create DP table for LCS length (not the actual LCS string)
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Build SCS by backtracking through the DP table
        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // Common character found
                result.append(str1.charAt(i - 1));
                i--; 
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Character from str1
                result.append(str1.charAt(i - 1));
                i--;
            } else {
                // Character from str2
                result.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // Add remaining characters from str1
        while (i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }
        
        // Add remaining characters from str2
        while (j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }
        
        // Reverse the result since we built it backward
        return result.reverse().toString();
    }
    
    // Helper method to check if a string consists of the same character repeated
    private boolean isRepeatedChar(String str) {
        if (str.length() <= 1) return true;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                return false;
            }
        }
        return true;
    }
}