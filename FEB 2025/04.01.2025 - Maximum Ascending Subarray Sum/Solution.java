class Solution {
    public int maxAscendingSum(int[] nums) {
        // Initialize maxSum as first element and currentSum as first element
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        // Iterate from second element to find ascending subarrays
        for (int i = 1; i < nums.length; i++) {
            // If current number is greater than previous number
            if (nums[i] > nums[i-1]) {
                // Add to current ascending subarray sum
                currentSum += nums[i];
            } else {
                // Start new ascending subarray from current number
                currentSum = nums[i];
            }
            
            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
