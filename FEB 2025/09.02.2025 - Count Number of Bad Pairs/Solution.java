class Solution {
    public long countBadPairs(int[] nums) {
        // Key insight: j - i != nums[j] - nums[i]
        // Rearranging: nums[j] - j != nums[i] - i
        // So if nums[i] - i equals nums[j] - j, they form a good pair
        // We can count good pairs and subtract from total possible pairs
        
        // Step 1: Create a map to store frequency of (nums[i] - i)
        Map<Integer, Long> freqMap = new HashMap<>();
        
        // Step 2: Calculate nums[i] - i for each element and store frequency
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - i;
            freqMap.put(diff, freqMap.getOrDefault(diff, 0L) + 1);
        }
        
        // Step 3: Calculate total possible pairs
        long totalPairs = ((long) nums.length * (nums.length - 1)) / 2;
        
        // Step 4: Calculate good pairs
        long goodPairs = 0;
        for (long freq : freqMap.values()) {
            // If we have n elements with same diff, we can form n*(n-1)/2 good pairs
            goodPairs += (freq * (freq - 1)) / 2;
        }
        
        // Step 5: Return bad pairs (total pairs - good pairs)
        return totalPairs - goodPairs;
    }
}