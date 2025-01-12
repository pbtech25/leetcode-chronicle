class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        
        // If length is odd, it can never be valid
        if (n % 2 != 0) return false;
        
        // First pass: left to right, checking for excess closing parentheses
        int wildcards = 0;  // count of positions we can change
        int balance = 0;    // count of open - close parentheses
        
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                wildcards++;
            } else if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            
            // If we have more closing than opening parentheses
            if (balance + wildcards < 0) {
                return false;
            }
        }
        
        // Second pass: right to left, checking for excess opening parentheses
        wildcards = 0;
        balance = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                wildcards++;
            } else if (s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }
            
            // If we have more opening than closing parentheses
            if (balance + wildcards < 0) {
                return false;
            }
        }
        
        return true;
    }
}