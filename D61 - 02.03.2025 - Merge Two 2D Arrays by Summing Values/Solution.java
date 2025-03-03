class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Create a map to store id -> value pairs
        Map<Integer, Integer> mergedMap = new HashMap<>();
        
        // Process first array
        for (int[] pair : nums1) {
            mergedMap.put(pair[0], pair[1]);
        }
        
        // Process second array, summing values for duplicate ids
        for (int[] pair : nums2) {
            int id = pair[0];
            int val = pair[1];
            mergedMap.put(id, mergedMap.getOrDefault(id, 0) + val);
        }
        
        // Convert map to result array
        int[][] result = new int[mergedMap.size()][2];
        int index = 0;
        
        // Sort by id and fill the result array
        List<Integer> sortedIds = new ArrayList<>(mergedMap.keySet());
        Collections.sort(sortedIds);
        
        for (int id : sortedIds) {
            result[index][0] = id;
            result[index][1] = mergedMap.get(id);
            index++;
        }
        
        return result;
    }
}
