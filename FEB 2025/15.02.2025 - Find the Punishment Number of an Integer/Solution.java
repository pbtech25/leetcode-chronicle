class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (canPartition(i * i, i)) {
                sum += i * i;
            }
        }
        return sum;
    }
    
    // Check if square can be partitioned to sum up to original number
    private boolean canPartition(int square, int target) {
        return backtrack(String.valueOf(square), 0, 0, target);
    }
    
    // Backtracking to try all possible partitions
    private boolean backtrack(String square, int index, int currentSum, int target) {
        // Base case: reached the end of the string
        if (index == square.length()) {
            return currentSum == target;
        }
        
        // Try all possible substrings starting from current index
        for (int i = index; i < square.length(); i++) {
            // Skip if starting with 0 and has more than one digit
            if (square.charAt(index) == '0' && i > index) {
                break;
            }
            
            // Parse the current substring as an integer
            int value = Integer.parseInt(square.substring(index, i + 1));
            
            // Check if adding this value would exceed the target
            if (currentSum + value > target) {
                break;
            }
            
            // Recursively check the rest of the string
            if (backtrack(square, i + 1, currentSum + value, target)) {
                return true;
            }
        }
        
        return false;
    }
}