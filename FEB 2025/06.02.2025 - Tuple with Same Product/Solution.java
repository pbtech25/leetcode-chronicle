class Solution {
    public int tupleSameProduct(int[] nums) {
        // Create a HashMap to store product frequencies
        Map<Integer, Integer> productFreq = new HashMap<>();
        int n = nums.length;
        
        // Calculate all possible products of two numbers
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productFreq.put(product, productFreq.getOrDefault(product, 0) + 1);
            }
        }
        
        // Calculate total valid tuples
        int result = 0;
        for (int freq : productFreq.values()) {
            if (freq > 1) {
                // For each pair of pairs with same product,
                // we can form 8 different valid tuples
                result += (freq * (freq - 1)) / 2 * 8;
            }
        }
        
        return result;
    }
}