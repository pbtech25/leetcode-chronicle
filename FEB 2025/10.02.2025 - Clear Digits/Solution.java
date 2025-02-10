class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (true) {
            // Find the first digit
            int digitIndex = findFirstDigit(sb);
            if (digitIndex == -1) {
                break;  // No more digits found
            }
            
            // Find the closest non-digit character to the left
            int leftCharIndex = findClosestLeftChar(sb, digitIndex);
            
            // Remove both characters (start from the right to maintain correct indices)
            sb.deleteCharAt(digitIndex);
            if (leftCharIndex != -1) {
                sb.deleteCharAt(leftCharIndex);
            }
        }
        
        return sb.toString();
    }
    
    // Helper method to find the first digit in the string
    private int findFirstDigit(StringBuilder s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return i;
            }
        }
        return -1;  // No digit found
    }
    
    // Helper method to find the closest non-digit character to the left
    private int findClosestLeftChar(StringBuilder s, int digitIndex) {
        for (int i = digitIndex - 1; i >= 0; i--) {
            if (!Character.isDigit(s.charAt(i))) {
                return i;
            }
        }
        return -1;  // No non-digit character found to the left
    }
}