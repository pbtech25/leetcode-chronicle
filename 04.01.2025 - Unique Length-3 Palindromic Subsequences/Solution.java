class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> uniquePalindromes = new HashSet<>();
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);
        Arrays.fill(lastOccurrence, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (firstOccurrence[charIndex] == -1) {
                firstOccurrence[charIndex] = i;
            }
            lastOccurrence[charIndex] = i;
        }
        
        for (int i = 0; i < 26; i++) {
            if (firstOccurrence[i] != -1 && lastOccurrence[i] != firstOccurrence[i]) {
                for (int j = firstOccurrence[i] + 1; j < lastOccurrence[i]; j++) {
                    String palindrome = "" + (char)(i + 'a') + s.charAt(j) + (char)(i + 'a');
                    uniquePalindromes.add(palindrome);
                }
            }
        }
        
        return uniquePalindromes.size();
    }
}
