class Solution {
    // Helper method to calculate sum of digits
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    
    public int maximumSum(int[] nums) {
        // Map to store the maximum two numbers for each digit sum
        Map<Integer, PriorityQueue<Integer>> digitSumMap = new HashMap<>();
        
        // Process each number
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            
            // Create a max heap for this digit sum if it doesn't exist
            digitSumMap.putIfAbsent(digitSum, new PriorityQueue<>(Collections.reverseOrder()));
            
            // Add the current number to its digit sum group
            digitSumMap.get(digitSum).offer(num);
        }
        
        int maxSum = -1;
        
        // Check each digit sum group
        for (PriorityQueue<Integer> group : digitSumMap.values()) {
            // If we have at least 2 numbers with the same digit sum
            if (group.size() >= 2) {
                // Get the two largest numbers in this group
                int first = group.poll();
                int second = group.poll();
                maxSum = Math.max(maxSum, first + second);
            }
        }
        
        return maxSum;
    }
}