class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than string length, impossible to construct k palindromes
        // as each palindrome needs at least one character
        if (k > s.length()) {
            return false;
        }
        
        // If k equals string length, we can always construct k palindromes
        // by using one character for each palindrome
        if (k == s.length()) {
            return true;
        }
        
        // Count frequency of each character
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Count characters with odd frequencies
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        if (k < oddCount) {
            return false;
        }
        
        return true;
    }
}
