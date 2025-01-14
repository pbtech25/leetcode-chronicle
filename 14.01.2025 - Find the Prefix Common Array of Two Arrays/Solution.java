class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        
        // Keep track of seen numbers in both arrays
        boolean[] seenA = new boolean[n + 1];
        boolean[] seenB = new boolean[n + 1];
        
        int commonCount = 0;
        
        // Process each index
        for (int i = 0; i < n; i++) {
            // Mark current number in A as seen
            seenA[A[i]] = true;
            
            // If this number was already seen in B, increment common count
            if (seenB[A[i]]) {
                commonCount++;
            }
            
            // Mark current number in B as seen
            seenB[B[i]] = true;
            
            // If this number was already seen in A, increment common count
            if (seenA[B[i]] && A[i] != B[i]) {
                commonCount++;
            }
            
            // If A[i] equals B[i], we need to count it only once
            if (A[i] == B[i]) {
                commonCount++;
            }
            
            result[i] = commonCount;
        }
        
        return result;
    }
}
