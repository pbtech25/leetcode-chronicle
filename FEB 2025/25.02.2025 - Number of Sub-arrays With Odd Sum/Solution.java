class Solution {
    public int numOfSubarrays(int[] arr) {
        // Constants
        final int MOD = 1_000_000_007;
        
        // Variables to track counts of even and odd prefix sums
        int evenCount = 1; // Start with 1 to account for empty prefix
        int oddCount = 0;
        
        int prefixSum = 0;
        long result = 0;
        
        // Iterate through the array
        for (int num : arr) {
            // Update prefix sum
            prefixSum += num;
            
            // Check if current prefix sum is odd or even
            if (prefixSum % 2 == 1) {
                // If current prefix sum is odd, we can form odd-sum subarrays
                // by subtracting all previous even prefix sums
                result = (result + evenCount) % MOD;
                oddCount++;
            } else {
                // If current prefix sum is even, we can form odd-sum subarrays
                // by subtracting all previous odd prefix sums
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }
        
        return (int) result;
    }
}