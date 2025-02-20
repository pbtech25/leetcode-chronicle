class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        
        // Use Cantor's diagonal argument
        // For each position i, look at nums[i][i] and flip that bit
        for (int i = 0; i < nums.length; i++) {
            // Get the character at diagonal position (i,i)
            char curr = nums[i].charAt(i);
            
            // Flip the bit: if it's '0', use '1', and vice versa
            result.append(curr == '0' ? '1' : '0');
        }
        
        return result.toString();
    }
}
