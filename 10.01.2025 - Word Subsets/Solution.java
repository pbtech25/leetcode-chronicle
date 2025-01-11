class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Result list to store universal strings
        List<String> result = new ArrayList<>();
        
        // Get the maximum frequency required for each character from words2
        int[] maxFreqWords2 = getMaxFrequencies(words2);
        
        // Check each string in words1
        for (String word : words1) {
            // Get frequency count of current word
            int[] freqWord = getFrequency(word);
            
            // Check if this word is universal
            if (isUniversal(freqWord, maxFreqWords2)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    // Helper method to get character frequency array for a single string
    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    
    // Helper method to get maximum frequencies required from words2
    private int[] getMaxFrequencies(String[] words2) {
        int[] maxFreq = new int[26];
        
        // For each word in words2
        for (String word : words2) {
            // Get frequency count of current word
            int[] currFreq = getFrequency(word);
            
            // Update maximum frequencies
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], currFreq[i]);
            }
        }
        
        return maxFreq;
    }
    
    // Helper method to check if a word from words1 is universal
    private boolean isUniversal(int[] wordFreq, int[] maxFreqWords2) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < maxFreqWords2[i]) {
                return false;
            }
        }
        return true;
    }
}