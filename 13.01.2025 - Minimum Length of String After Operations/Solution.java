class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        // Continue while we have at least 2 characters
        while (left < right && s.charAt(left) == s.charAt(right)) {
            char curr = s.charAt(left);
            
            // Skip all same characters from left
            while (left <= right && s.charAt(left) == curr) {
                left++;
            }
            
            // Skip all same characters from right
            while (left <= right && s.charAt(right) == curr) {
                right--;
            }
        }
        
        // Return remaining length
        return Math.max(0, right - left + 1);
    }
}