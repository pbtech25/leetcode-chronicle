class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Check each word if it's a substring of any other word
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Skip comparing with itself
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    // Break inner loop once we find a match
                    break;
                }
            }
        }
        
        return result;
    }
}