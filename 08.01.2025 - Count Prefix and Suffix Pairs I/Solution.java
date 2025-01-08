class Solution {
    // Helper function to check if str1 is both prefix and suffix of str2
    private boolean isPrefixAndSuffix(String str1, String str2) {
        // If str1 is longer than str2, it can't be a prefix and suffix
        if (str1.length() > str2.length()) {
            return false;
        }
        
        // Check if str1 is prefix of str2
        boolean isPrefix = str2.startsWith(str1);
        // Check if str1 is suffix of str2
        boolean isSuffix = str2.endsWith(str1);
        
        // Return true only if it's both prefix and suffix
        return isPrefix && isSuffix;
    }
    
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;
        
        // Check all possible pairs where i < j
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}