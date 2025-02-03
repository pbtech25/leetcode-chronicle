class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int maxLength = 1;  // minimum length is always 1
        
        // For each starting position
        for (int i = 0; i < n; i++) {
            // Check increasing sequence
            int len = 1;
            int j = i;
            while (j + 1 < n && nums[j + 1] > nums[j]) {
                len++;
                j++;
            }
            maxLength = Math.max(maxLength, len);
            
            // Check decreasing sequence
            len = 1;
            j = i;
            while (j + 1 < n && nums[j + 1] < nums[j]) {
                len++;
                j++;
            }
            maxLength = Math.max(maxLength, len);
        }
        
        return maxLength;
    }
}
