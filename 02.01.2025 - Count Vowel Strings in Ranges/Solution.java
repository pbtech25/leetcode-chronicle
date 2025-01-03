class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
    private boolean startsAndEndsWithVowel(String word) {
        if (word.isEmpty()) return false;
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }
    
    public int[] vowelStrings(String[] words, int[][] queries) {
        int wordCount = words.length;
        int[] prefixSum = new int[wordCount];

        prefixSum[0] = startsAndEndsWithVowel(words[0]) ? 1 : 0;
        for (int i = 1; i < wordCount; i++) {
            prefixSum[i] = prefixSum[i - 1] + (startsAndEndsWithVowel(words[i]) ? 1 : 0);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = start == 0 ? prefixSum[end] : prefixSum[end] - prefixSum[start - 1];
        }
        
        return result;
    }
}