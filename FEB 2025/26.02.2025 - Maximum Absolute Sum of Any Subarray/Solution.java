class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // To find the maximum absolute sum, we need to consider both
        // the maximum positive sum and the minimum negative sum
        
        int maxSum = 0;         // Max positive sum
        int minSum = 0;         // Min negative sum
        int currentMax = 0;     // Current running max sum
        int currentMin = 0;     // Current running min sum
        
        for (int num : nums) {
            // Update running max sum (Kadane's algorithm for max subarray sum)
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
            
            // Update running min sum (modified Kadane's for min subarray sum)
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }
        
        // The maximum absolute sum will be either the maximum positive sum
        // or the absolute value of the minimum negative sum
        return Math.max(maxSum, Math.abs(minSum));
    }
}