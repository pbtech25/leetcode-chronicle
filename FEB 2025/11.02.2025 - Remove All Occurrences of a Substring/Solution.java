class Solution {
    public String removeOccurrences(String s, String part) {
        // Keep removing part until it's no longer found in s
        while (s.contains(part)) {
            // Find the index of the first occurrence
            int index = s.indexOf(part);
            
            // If part is found, remove it by taking substring before and after
            if (index != -1) {
                s = s.substring(0, index) + s.substring(index + part.length());
            }
        }
        
        return s;
    }
}