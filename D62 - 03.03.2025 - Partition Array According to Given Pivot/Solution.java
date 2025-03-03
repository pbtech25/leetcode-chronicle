class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Count elements smaller, equal, and greater than pivot
        int smallerCount = 0;
        int equalCount = 0;
        
        for (int num : nums) {
            if (num < pivot) {
                smallerCount++;
            } else if (num == pivot) {
                equalCount++;
            }
        }
        
        // Initialize pointers for each section in the result array
        int smallerIndex = 0;
        int equalIndex = smallerCount;
        int greaterIndex = smallerCount + equalCount;
        
        // Place elements in their respective sections while maintaining relative order
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[smallerIndex++] = nums[i];
            } else if (nums[i] == pivot) {
                result[equalIndex++] = nums[i];
            } else {
                result[greaterIndex++] = nums[i];
            }
        }
        
        return result;
    }
}