class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int rotations = 0;
        
        // Count the number of positions where nums[i] > nums[i+1]
        // In a sorted and rotated array, this can happen at most once
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                rotations++;
            }
            
            // If we find more than one rotation point, return false
            if (rotations > 1) {
                return false;
            }
        }
        
        // If we have 0 or 1 rotation points, the array was sorted and rotated
        return true;
    }
}