class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Apply the operations sequentially
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        // Shift all zeros to the end
        int[] result = new int[n];
        int nonZeroIndex = 0;
        
        // Copy all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                result[nonZeroIndex++] = nums[i];
            }
        }
        
        // Fill the rest of the array with zeros
        while (nonZeroIndex < n) {
            result[nonZeroIndex++] = 0;
        }
        
        return result;
    }
}