import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        // Use a min heap to always get the two smallest elements efficiently
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        
        // Add all elements to the min heap
        // Using long to handle potential integer overflow
        for (int num : nums) {
            minHeap.offer((long) num);
        }
        
        int operations = 0;
        
        // Continue operations while we have at least 2 elements
        // and the smallest element is less than k
        while (minHeap.size() >= 2 && minHeap.peek() < k) {
            // Get the two smallest elements
            long x = minHeap.poll();
            long y = minHeap.poll();
            
            // Calculate new value according to the formula
            // min(x,y) * 2 + max(x,y)
            long newValue = Math.min(x, y) * 2 + Math.max(x, y);
            
            // Add the new value back to the heap
            minHeap.offer(newValue);
            
            operations++;
        }
        
        return operations;
    }
}